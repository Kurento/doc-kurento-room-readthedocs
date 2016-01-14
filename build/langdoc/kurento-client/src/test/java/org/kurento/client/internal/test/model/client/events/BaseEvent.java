
package org.kurento.client.internal.test.model.client.events;

import org.kurento.client.Event;
import org.kurento.client.internal.server.Param;

public class BaseEvent implements Event {

  private String prop2;

  public BaseEvent(@Param("prop2") String prop2) {
    super();
    this.prop2 = prop2;
  }

  public String getProp2() {
    return prop2;
  }

  public void setProp2(String prop2) {
    this.prop2 = prop2;
  }

}
