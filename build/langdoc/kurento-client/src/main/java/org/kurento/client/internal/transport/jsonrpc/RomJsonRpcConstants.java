
package org.kurento.client.internal.transport.jsonrpc;

public class RomJsonRpcConstants {

  public static final String CREATE_METHOD = "create";
  public static final String CREATE_CONSTRUCTOR_PARAMS = "constructorParams";
  public static final String CREATE_TYPE = "type";

  public static final String INVOKE_METHOD = "invoke";
  public static final String INVOKE_OPERATION_PARAMS = "operationParams";
  public static final String INVOKE_OPERATION_NAME = "operation";
  public static final String INVOKE_OBJECT = "object";

  public static final String RELEASE_METHOD = "release";
  public static final String RELEASE_OBJECT = "object";

  public static final String ONEVENT_METHOD = "onEvent";
  public static final String ONEVENT_OBJECT = "object";
  public static final String ONEVENT_TYPE = "type";
  public static final String ONEVENT_DATA = "data";
  public static final String ONEVENT_SUBSCRIPTION = "subscription";

  public static final String SUBSCRIBE_METHOD = "subscribe";
  public static final String SUBSCRIBE_OBJECT = "object";
  public static final String SUBSCRIBE_TYPE = "type";

  public static final String UNSUBSCRIBE_METHOD = "unsubscribe";
  public static final String UNSUBSCRIBE_OBJECT = "object";
  public static final String UNSUBSCRIBE_LISTENER = "subscription";

  public static final String TRANSACTION_METHOD = "transaction";
  public static final String TRANSACTION_OPERATIONS = "operations";

}
