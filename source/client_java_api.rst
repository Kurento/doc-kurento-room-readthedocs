%%%%%%%%%%%%%%%
Client Java API
%%%%%%%%%%%%%%%

The developer of room applications can use this API when implementing a Java or 
an Android client.

It is actually only a wrapper over the JSON-RPC protocol used to communicate with
the Room Server.

The usefulness of this module is that it allows to create and manage room 
participants in a programmatic manner, or that it can be used to create an
Android room client. 

Please note that we haven't tested if it's actually working on the Android 
platform (should depend on the support for the WebSocket client implementation).

Using the library
#################

This client can be obtained as a Maven dependency with the following coordinates:

.. sourcecode:: xml

   <dependency>
     <groupId>org.kurento</groupId>
     <artifactId>kurento-room-client</artifactId>
     <version>6.3.1</version>
   </dependency>

With this dependency, the developer can use the class 
``org.kurento.room.client.KurentoRoomClient`` to create rooms or connect to
existing sessions.

Usage
#####

To connect to a Kurento Room Server it is required to create an instance of 
``KurentoRoomClient`` class indicating the URI of the application server's WebSocket endpoint:

.. sourcecode:: java

   KurentoRoomClient client = new KurentoRoomClient("wss://roomAddress:roomPort/room");

In background, a websocket connection is made between the Java application and 
the Kurento Room Server.

As the client is no more than a wrapper for sending and receiving the messages
defined by the Room Server's :doc:`WebSocket API <websocket_api_room_server>`,
the methods of this API are quite easy to understand (as they reflect the 
JSON-RPC messages).

Notifications
-------------

The client maintains a notifications' queue where it stores messages received from
the server. The developer should run the following method in a separate thread 
using an infinite loop:

.. sourcecode:: java

   Notification notif = client.getServerNotification();

The ``Notification`` abstract class publishes a method that can be used to find
its exact type:

.. sourcecode:: java

   if (notif == null)
      return;
   log.debug("Polled notif {}", notif);
   switch (notif.getMethod()) {
      case ICECANDIDATE_METHOD:
         IceCandidateInfo info = (IceCandidateInfo) notif;
         //do something with the ICE Candidate information
         ...
         break;
      ...
   }

The notification types are the following and they contain information for the
different types of events triggered from the server-side:

- ``org.kurento.room.client.internal.IceCandidateInfo``
- ``org.kurento.room.client.internal.MediaErrorInfo``
- ``org.kurento.room.client.internal.ParticipantEvictedInfo``
- ``org.kurento.room.client.internal.ParticipantJoinedInfo``
- ``org.kurento.room.client.internal.ParticipantLeftInfo``
- ``org.kurento.room.client.internal.ParticipantPublishedInfo``
- ``org.kurento.room.client.internal.ParticipantUnpublishedInfo``
- ``org.kurento.room.client.internal.RoomClosedInfo``
- ``org.kurento.room.client.internal.SendMessageInfo``

Join room
---------

.. sourcecode:: java

   Map<String, List<String>> newPeers = client.joinRoom(room, username);

This method sends the ``joinRoom`` message and returns a list containing the existing
participants and their published streams. 

Leave room
----------

.. sourcecode:: java

   client.leaveRoom();

This method sends the ``leaveRoom`` message.

Publish
-------

.. sourcecode:: java

   String sdpAnswer = client.publishVideo(sdpOffer, false);

This method sends the ``publishVideo`` message. It returns the SDP answer from
the publishing media endpoint on the server.

Unpublish
---------

.. sourcecode:: java

   client.unpublishVideo();

This method sends the ``unpublishVideo`` message.

Subscribe
---------

.. sourcecode:: java

   String sdpAnswer = client.receiveVideoFrom(sender, sdpOffer);

This method sends the ``receiveVideoFrom`` message. It returns the SDP answer from
the subscribing media endpoint on the server.

Unsubscribe
-----------

.. sourcecode:: java

   client.unsubscribeFromVideo(sender);

This method sends the ``unsubscribeFromVideo`` message.

Send ICE Candidate 
------------------

.. sourcecode:: java

   client.onIceCandidate(endpointName, candidate, sdpMid, sdpMLineIndex);

This method sends the ``onIceCandidate`` message, containing a local ICE Candidate
for the connection with the specified endpoint.

Send message
------------

.. sourcecode:: java

   client.sendMessage(userName, roomName, message);

This method sends the ``sendMessage`` message.