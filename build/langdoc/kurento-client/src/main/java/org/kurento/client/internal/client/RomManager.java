package org.kurento.client.internal.client;

import java.lang.reflect.Type;
import java.util.List;

import org.kurento.client.Continuation;
import org.kurento.client.Transaction;
import org.kurento.client.internal.TransactionImpl;
import org.kurento.client.internal.client.operation.MediaObjectCreationOperation;
import org.kurento.client.internal.client.operation.Operation;
import org.kurento.client.internal.transport.serialization.ObjectRefsManager;
import org.kurento.client.internal.transport.serialization.ParamsFlattener;
import org.kurento.jsonrpc.Props;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RomManager implements ObjectRefsManager {

	private static final Logger log = LoggerFactory.getLogger(RomManager.class);

	private static ParamsFlattener FLATTENER = ParamsFlattener.getInstance();

	private final RomClientObjectManager manager;
	private final RomClient client;

	public RomManager(RomClient client) {
		this.client = client;
		this.manager = new RomClientObjectManager(client);
		if (client != null) {
			this.client.addRomEventHandler(manager);
		}
	}

	// FIXME: Improve concurrency
	public synchronized RemoteObject create(String remoteClassName,
			Props constructorParams) {
		String objectRef = client.create(remoteClassName, constructorParams);

		return new RemoteObject(objectRef, remoteClassName, this);
	}

	public synchronized RemoteObject create(String remoteClassName,
			Props constructorParams, Transaction tx) {

		TransactionImpl txImpl = (TransactionImpl) tx;

		RemoteObject remoteObject = new RemoteObject(txImpl.nextObjectRef(),
				remoteClassName, false, this);

		MediaObjectCreationOperation op = new MediaObjectCreationOperation(
				remoteClassName, constructorParams, remoteObject);

		txImpl.addOperation(op);

		return remoteObject;

	}

	public synchronized RemoteObject create(String remoteClassName) {
		return create(remoteClassName, (Props) null);
	}

	public synchronized void create(final String remoteClassName,
			final Props constructorParams, final Continuation<RemoteObject> cont) {

		client.create(remoteClassName, constructorParams,
				new Continuation<String>() {
			@Override
			public void onSuccess(String objectRef) {
				try {
					cont.onSuccess(new RemoteObject(objectRef,
							remoteClassName, RomManager.this));
				} catch (Exception e) {
					log.warn(
							"[Continuation] error invoking onSuccess implemented by client",
							e);
				}
			}

			@Override
			public void onError(Throwable cause) {
				try {
					cont.onError(cause);
				} catch (Exception e) {
					log.warn(
							"[Continuation] error invoking onError implemented by client",
							e);
				}
			}
		});
	}

	public synchronized void create(String remoteClassName,
			Continuation<RemoteObject> cont) {
		create(remoteClassName, null, cont);
	}

	@Override
	public synchronized Object getObject(String objectRef) {
		return manager.getObject(objectRef);
	}

	@SuppressWarnings("unchecked")
	public synchronized <T> T getById(String objectRef, Class<T> clazz) {

		RemoteObject remoteObject = (RemoteObject) this.getObject(objectRef);

		if (remoteObject == null) {

			clazz = obtainConcreteClass(objectRef, clazz);

			remoteObject = new RemoteObject(objectRef, clazz.getSimpleName(),
					this);

			RemoteObjectInvocationHandler.newProxy(remoteObject, this, clazz);
		}

		return (T) remoteObject.getKurentoObject();
	}

	@SuppressWarnings("unchecked")
	private <T> Class<T> obtainConcreteClass(String objectRef, Class<T> clazz) {

		if (objectRef.endsWith(clazz.getSimpleName())) {
			return clazz;
		} else {

			String romFullyClassName = objectRef.substring(objectRef
					.lastIndexOf("_") + 1);

			return (Class<T>) FLATTENER.getClassFor(romFullyClassName);
		}
	}

	public synchronized void registerObject(String objectRef,
			RemoteObject remoteObject) {
		this.manager.registerObject(objectRef, remoteObject);
	}

	public void destroy() {
		log.info("Closing RomManager");
		this.client.destroy();
	}

	public <E> E invoke(String objectRef, String methodName, Props params,
			Class<E> clazz) {
		return client.invoke(objectRef, methodName, params, clazz);
	}

	public Object invoke(String objectRef, String operationName,
			Props operationParams, Type type) {
		return client.invoke(objectRef, operationName, operationParams, type);
	}

	public void release(String objectRef) {
		client.release(objectRef);
		manager.releaseObject(objectRef);
	}

	public String subscribe(String objectRef, String eventType) {
		return client.subscribe(objectRef, eventType);
	}

	public void unsubscribe(String objectRef, String listenerSubscription) {
		client.unsubscribe(objectRef, listenerSubscription);
	}

	public Object invoke(String objectRef, String operationName,
			Props operationParams, Type type, Continuation<?> cont) {
		return client.invoke(objectRef, operationName, operationParams, type,
				cont);
	}

	public void release(final String objectRef, final Continuation<Void> cont) {
		client.release(objectRef, new DefaultContinuation<Void>(cont) {
			@Override
			public void onSuccess(Void result) {
				manager.releaseObject(objectRef);
				try {
					cont.onSuccess(null);
				} catch (Exception e) {
					log.warn(
							"[Continuation] error invoking onSuccess implemented by client",
							e);
				}
			}
		});
	}

	public String subscribe(String objectRef, String type,
			Continuation<String> cont) {
		return client.subscribe(objectRef, type, cont);
	}

	public void unsubscribe(String objectRef, String listenerRegistration,
			Continuation<Void> cont) {
		client.unsubscribe(objectRef, listenerRegistration, cont);
	}

	public void addRomEventHandler(RomEventHandler eventHandler) {
		client.addRomEventHandler(eventHandler);
	}

	public RomClientObjectManager getObjectManager() {
		return manager;
	}

	public void transaction(List<Operation> operations) {
		for (Operation op : operations) {
			op.setManager(this);
		}
		client.transaction(operations);
	}

	public void transaction(final List<Operation> operations,
			final Continuation<Void> continuation) {

		for (Operation op : operations) {
			op.setManager(this);
		}

		client.transaction(operations, new Continuation<Void>() {
			@Override
			public void onSuccess(Void result) throws Exception {
				continuation.onSuccess(null);
			}

			@Override
			public void onError(Throwable cause) throws Exception {
				transaction(operations, continuation);
			}
		});
	}

	public RomClient getRomClient() {
		return client;
	}

	public synchronized RemoteObject createWithKurentoObject(Class<?> clazz,
			Props props, Transaction transaction) {

		RemoteObject remoteObject = this.create(clazz.getSimpleName(), props,
				transaction);

		RemoteObjectInvocationHandler.newProxy(remoteObject, this, clazz);

		return remoteObject;
	}

	public synchronized RemoteObject createWithKurentoObject(Class<?> clazz,
			Props props) {

		RemoteObject remoteObject = this.create(clazz.getSimpleName(), props);

		RemoteObjectInvocationHandler.newProxy(remoteObject, this, clazz);

		return remoteObject;

	}
}
