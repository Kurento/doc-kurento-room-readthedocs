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
platform (depends on the WebSocket implementation).

Using the library
#################

This client can be obtained as a Maven dependency with the following coordinates:

.. sourcecode:: xml

   <dependency>
     <groupId>org.kurento</groupId>
     <artifactId>kurento-room-client</artifactId>
     <version>|MAVEN_VERSION|</version>
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