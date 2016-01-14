
package org.kurento.client.internal.test.model.client.events;

import org.kurento.client.internal.server.Param;

public class SampleEvent extends BaseEvent {

  private String prop1;

  public SampleEvent(@Param("prop2") String prop2, @Param("prop1") String prop1) {
    super(prop2);
    this.prop1 = prop1;
  }

  public String getProp1() {
    return prop1;
  }

  public void setProp1(String prop1) {
    this.prop1 = prop1;
  }

}
