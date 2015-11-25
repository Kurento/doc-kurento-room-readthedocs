/**
 * This file is generated with Kurento-maven-plugin.
 * Please don't edit.
 */
package org.kurento.client;


/**
 *
 * WebRtcEndpoint interface. This type of <code>Endpoint</code> offers media streaming using WebRTC.
 *
 **/
@org.kurento.client.internal.RemoteClass
public interface WebRtcEndpoint extends BaseRtpEndpoint {

     String getStunServerAddress();

     void getStunServerAddress(Continuation<String> cont);

     TFuture<String> getStunServerAddress(Transaction tx);

     void setStunServerAddress(@org.kurento.client.internal.server.Param("stunServerAddress") String stunServerAddress);

     void setStunServerAddress(@org.kurento.client.internal.server.Param("stunServerAddress") String stunServerAddress, Continuation<Void> cont);

     void setStunServerAddress(@org.kurento.client.internal.server.Param("stunServerAddress") String stunServerAddress, Transaction tx);
     int getStunServerPort();

     void getStunServerPort(Continuation<Integer> cont);

     TFuture<Integer> getStunServerPort(Transaction tx);

     void setStunServerPort(@org.kurento.client.internal.server.Param("stunServerPort") int stunServerPort);

     void setStunServerPort(@org.kurento.client.internal.server.Param("stunServerPort") int stunServerPort, Continuation<Void> cont);

     void setStunServerPort(@org.kurento.client.internal.server.Param("stunServerPort") int stunServerPort, Transaction tx);
     String getTurnUrl();

     void getTurnUrl(Continuation<String> cont);

     TFuture<String> getTurnUrl(Transaction tx);

     void setTurnUrl(@org.kurento.client.internal.server.Param("turnUrl") String turnUrl);

     void setTurnUrl(@org.kurento.client.internal.server.Param("turnUrl") String turnUrl, Continuation<Void> cont);

     void setTurnUrl(@org.kurento.client.internal.server.Param("turnUrl") String turnUrl, Transaction tx);


/**
 *
 * Init the gathering of ICE candidates.
 * It must be called after SdpEndpoint::generateOffer or SdpEndpoint::processOffer
 *
 **/
  void gatherCandidates();

/**
 *
 * Asynchronous version of gatherCandidates:
 * {@link Continuation#onSuccess} is called when the action is
 * done. If an error occurs, {@link Continuation#onError} is called.
 * @see WebRtcEndpoint#gatherCandidates
 *
 **/
    void gatherCandidates(Continuation<Void> cont);

/**
 *
 * Init the gathering of ICE candidates.
 * It must be called after SdpEndpoint::generateOffer or SdpEndpoint::processOffer
 *
 **/
    void gatherCandidates(Transaction tx);


/**
 *
 * Provide a remote ICE candidate
 *
 * @param candidate
 *       Remote ICE candidate
 *
 **/
  void addIceCandidate(@org.kurento.client.internal.server.Param("candidate") org.kurento.client.IceCandidate candidate);

/**
 *
 * Asynchronous version of addIceCandidate:
 * {@link Continuation#onSuccess} is called when the action is
 * done. If an error occurs, {@link Continuation#onError} is called.
 * @see WebRtcEndpoint#addIceCandidate
 *
 * @param candidate
 *       Remote ICE candidate
 *
 **/
    void addIceCandidate(@org.kurento.client.internal.server.Param("candidate") org.kurento.client.IceCandidate candidate, Continuation<Void> cont);

/**
 *
 * Provide a remote ICE candidate
 *
 * @param candidate
 *       Remote ICE candidate
 *
 **/
    void addIceCandidate(Transaction tx, @org.kurento.client.internal.server.Param("candidate") org.kurento.client.IceCandidate candidate);

    /**
     * Add a {@link EventListener} for event {@link OnIceCandidateEvent}. Synchronous call.
     *
     * @param  listener Listener to be called on OnIceCandidateEvent
     * @return ListenerSubscription for the given Listener
     *
     **/
    @org.kurento.client.internal.server.EventSubscription(OnIceCandidateEvent.class)
    ListenerSubscription addOnIceCandidateListener(EventListener<OnIceCandidateEvent> listener);
    /**
     * Add a {@link EventListener} for event {@link OnIceCandidateEvent}. Asynchronous call.
     * Calls Continuation&lt;ListenerSubscription&gt; when it has been added.
     *
     * @param listener Listener to be called on OnIceCandidateEvent
     * @param cont     Continuation to be called when the listener is registered
     *
     **/
    @org.kurento.client.internal.server.EventSubscription(OnIceCandidateEvent.class)
    void addOnIceCandidateListener(EventListener<OnIceCandidateEvent> listener, Continuation<ListenerSubscription> cont);
    
	/**
     * Remove a {@link ListenerSubscription} for event {@link OnIceCandidateEvent}. Synchronous call.
     *
     * @param listenerSubscription Listener subscription to be removed
     *
     **/
    @org.kurento.client.internal.server.EventSubscription(OnIceCandidateEvent.class)
    void removeOnIceCandidateListener(ListenerSubscription listenerSubscription);
    /**
     * Remove a {@link ListenerSubscription} for event {@link OnIceCandidateEvent}. Asynchronous call.
     * Calls Continuation&lt;Void&gt; when it has been removed.
     *
     * @param listenerSubscription Listener subscription to be removed
     * @param cont                 Continuation to be called when the listener is removed
     *
     **/
    @org.kurento.client.internal.server.EventSubscription(OnIceCandidateEvent.class)
    void removeOnIceCandidateListener(ListenerSubscription listenerSubscription, Continuation<Void> cont);
    /**
     * Add a {@link EventListener} for event {@link OnIceGatheringDoneEvent}. Synchronous call.
     *
     * @param  listener Listener to be called on OnIceGatheringDoneEvent
     * @return ListenerSubscription for the given Listener
     *
     **/
    @org.kurento.client.internal.server.EventSubscription(OnIceGatheringDoneEvent.class)
    ListenerSubscription addOnIceGatheringDoneListener(EventListener<OnIceGatheringDoneEvent> listener);
    /**
     * Add a {@link EventListener} for event {@link OnIceGatheringDoneEvent}. Asynchronous call.
     * Calls Continuation&lt;ListenerSubscription&gt; when it has been added.
     *
     * @param listener Listener to be called on OnIceGatheringDoneEvent
     * @param cont     Continuation to be called when the listener is registered
     *
     **/
    @org.kurento.client.internal.server.EventSubscription(OnIceGatheringDoneEvent.class)
    void addOnIceGatheringDoneListener(EventListener<OnIceGatheringDoneEvent> listener, Continuation<ListenerSubscription> cont);
    
	/**
     * Remove a {@link ListenerSubscription} for event {@link OnIceGatheringDoneEvent}. Synchronous call.
     *
     * @param listenerSubscription Listener subscription to be removed
     *
     **/
    @org.kurento.client.internal.server.EventSubscription(OnIceGatheringDoneEvent.class)
    void removeOnIceGatheringDoneListener(ListenerSubscription listenerSubscription);
    /**
     * Remove a {@link ListenerSubscription} for event {@link OnIceGatheringDoneEvent}. Asynchronous call.
     * Calls Continuation&lt;Void&gt; when it has been removed.
     *
     * @param listenerSubscription Listener subscription to be removed
     * @param cont                 Continuation to be called when the listener is removed
     *
     **/
    @org.kurento.client.internal.server.EventSubscription(OnIceGatheringDoneEvent.class)
    void removeOnIceGatheringDoneListener(ListenerSubscription listenerSubscription, Continuation<Void> cont);
    /**
     * Add a {@link EventListener} for event {@link OnIceComponentStateChangedEvent}. Synchronous call.
     *
     * @param  listener Listener to be called on OnIceComponentStateChangedEvent
     * @return ListenerSubscription for the given Listener
     *
     **/
    @org.kurento.client.internal.server.EventSubscription(OnIceComponentStateChangedEvent.class)
    ListenerSubscription addOnIceComponentStateChangedListener(EventListener<OnIceComponentStateChangedEvent> listener);
    /**
     * Add a {@link EventListener} for event {@link OnIceComponentStateChangedEvent}. Asynchronous call.
     * Calls Continuation&lt;ListenerSubscription&gt; when it has been added.
     *
     * @param listener Listener to be called on OnIceComponentStateChangedEvent
     * @param cont     Continuation to be called when the listener is registered
     *
     **/
    @org.kurento.client.internal.server.EventSubscription(OnIceComponentStateChangedEvent.class)
    void addOnIceComponentStateChangedListener(EventListener<OnIceComponentStateChangedEvent> listener, Continuation<ListenerSubscription> cont);
    
	/**
     * Remove a {@link ListenerSubscription} for event {@link OnIceComponentStateChangedEvent}. Synchronous call.
     *
     * @param listenerSubscription Listener subscription to be removed
     *
     **/
    @org.kurento.client.internal.server.EventSubscription(OnIceComponentStateChangedEvent.class)
    void removeOnIceComponentStateChangedListener(ListenerSubscription listenerSubscription);
    /**
     * Remove a {@link ListenerSubscription} for event {@link OnIceComponentStateChangedEvent}. Asynchronous call.
     * Calls Continuation&lt;Void&gt; when it has been removed.
     *
     * @param listenerSubscription Listener subscription to be removed
     * @param cont                 Continuation to be called when the listener is removed
     *
     **/
    @org.kurento.client.internal.server.EventSubscription(OnIceComponentStateChangedEvent.class)
    void removeOnIceComponentStateChangedListener(ListenerSubscription listenerSubscription, Continuation<Void> cont);
    



    public class Builder extends AbstractBuilder<WebRtcEndpoint> {

/**
 *
 * Creates a Builder for WebRtcEndpoint
 *
 **/
    public Builder(org.kurento.client.MediaPipeline mediaPipeline){

      super(WebRtcEndpoint.class,mediaPipeline);

      props.add("mediaPipeline",mediaPipeline);
    }

/**
 *
 * Activate data channels support
 *
 **/
    public Builder useDataChannels(){
      props.add("useDataChannels",Boolean.TRUE);
      return this;
    }
    }


}