/**
 * This file is generated with Kurento ktool-rom-processor.
 * Please don't edit. Changes should go to kms-interface-rom and
 * ktool-rom-processor templates.
 */
package org.kurento.client;


/**
 *
 * Notify the creation of a new data channel.
 *
 **/
public class OnDataChannelOpenedEvent extends MediaEvent {

/**
 *
 * The channel identifier
 *
 **/
	private int channelId;

/**
 *
 * Notify the creation of a new data channel.
 *
 * @param source
 *       Object that raised the event
 * @param timestamp
 *       
 * @param tags
 *       
 * @param type
 *       Type of event that was raised
 * @param channelId
 *       The channel identifier
 *
 **/
  public OnDataChannelOpenedEvent(@org.kurento.client.internal.server.Param("source") org.kurento.client.MediaObject source, @org.kurento.client.internal.server.Param("timestamp") String timestamp, @org.kurento.client.internal.server.Param("tags") java.util.List<org.kurento.client.Tag> tags, @org.kurento.client.internal.server.Param("type") String type, @org.kurento.client.internal.server.Param("channelId") int channelId) {
    super(source, timestamp, tags, type);
    this.channelId = channelId;
  }

/**
 *
 * Getter for the channelId property
 * @return The channel identifier *
 **/
	public int getChannelId() {
		return channelId;
	}

/**
 *
 * Setter for the channelId property
 *
 * @param channelId
 *       The channel identifier
 *
 **/
	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}

}
