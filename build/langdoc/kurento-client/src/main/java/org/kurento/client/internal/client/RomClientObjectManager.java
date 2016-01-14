
package org.kurento.client.internal.client;

import java.util.concurrent.ConcurrentMap;

import org.kurento.client.internal.transport.serialization.ObjectRefsManager;
import org.kurento.jsonrpc.Props;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.MapMaker;

public class RomClientObjectManager implements RomEventHandler, ObjectRefsManager {

  private static final Logger log = LoggerFactory.getLogger(RomClientObjectManager.class);

  private final ConcurrentMap<String, RemoteObject> objects = new MapMaker().weakValues().makeMap();

  private final RomClient client;

  public RomClientObjectManager(RomClient client) {
    this.client = client;
  }

  public RomClient getClient() {
    return client;
  }

  @Override
  public void processEvent(String objectRef, String subscription, String type, Props data) {

    RemoteObject object = objects.get(objectRef);

    if (object == null) {
      log.error(
          "Trying to propagate a event with type={} and data={} to object {}, "
              + "but that doesn't exist in the client. Objects are={}",
          type, data, objectRef, objects);
      return;
    }

    object.fireEvent(type, data);
  }

  public void registerObject(String objectRef, RemoteObject remoteObject) {
    this.objects.put(objectRef, remoteObject);
  }

  public void releaseObject(String objectRef) {
    this.objects.remove(objectRef);
  }

  public RemoteObject getRemoteObject(String objectRef) {
    return this.objects.get(objectRef);
  }

  @Override
  public Object getObject(String objectRef) {
    return this.objects.get(objectRef);
  }

}
