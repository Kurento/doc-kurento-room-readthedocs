/**
 * This file is generated with Kurento ktool-rom-processor.
 * Please don't edit. Changes shoult go to kms-interface-rom and
 * ktool-rom-processor templates.
 */
package org.kurento.client;

import org.kurento.client.internal.client.DefaultContinuation;
import org.kurento.client.internal.client.RemoteObject;
import org.kurento.client.internal.client.RemoteObjectInvocationHandler;
import org.kurento.client.internal.client.RomManager;
import org.kurento.jsonrpc.Props;

/**
 * Kurento Media Builder base interface
 *
 * Builds a {@code <T>} object, either synchronously using {@link #build} or
 * asynchronously using {@link #buildAsync}
 *
 * @param T
 *            the type of object to build
 *
 **/
public class AbstractBuilder<T> {

	protected final Props props;
	private final RomManager manager;
	private final Class<?> clazz;

	public AbstractBuilder(Class<?> clazz, KurentoObject kurentoObject) {

		this.props = new Props();
		this.clazz = clazz;
		this.manager = RemoteObjectInvocationHandler.getFor(kurentoObject)
				.getRomManager();
	}

	public AbstractBuilder(Class<?> clazz, RomManager manager) {

		this.props = new Props();
		this.clazz = clazz;
		this.manager = manager;
	}

	/**
	 * Builds an object synchronously using the builder design pattern
	 *
	 * @return <T> The type of object
	 *
	 **/
	@SuppressWarnings("unchecked")
	public T build() {

		RemoteObject remoteObject = manager.createWithKurentoObject(clazz,
				props);

		return (T) remoteObject.getKurentoObject();

	}

	@SuppressWarnings("unchecked")
	public T build(Transaction transaction) {

		RemoteObject remoteObject = manager.createWithKurentoObject(clazz,
				props, transaction);

		return (T) remoteObject.getKurentoObject();
	}

	/**
	 * Builds an object asynchronously using the builder design pattern.
	 *
	 * The continuation will have {@link Continuation#onSuccess} called when the
	 * object is ready, or {@link Continuation#onError} if an error occurs
	 *
	 * @param continuation
	 *            will be called when the object is built
	 *
	 *
	 **/
	public void buildAsync(final Continuation<T> continuation) {

		manager.create(clazz.getSimpleName(), props,
				new DefaultContinuation<RemoteObject>(continuation) {
					@SuppressWarnings("unchecked")
					@Override
					public void onSuccess(RemoteObject remoteObject) {
						try {
							continuation
									.onSuccess((T) RemoteObjectInvocationHandler
											.newProxy(remoteObject, manager,
													clazz));
						} catch (Exception e) {
							log.warn(
									"[Continuation] error invoking onSuccess implemented by client",
									e);
						}
					}
				});

	}

}
