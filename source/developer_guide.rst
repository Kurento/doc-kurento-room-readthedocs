%%%%%%%%%%%%%%%
Developer guide
%%%%%%%%%%%%%%%

Quick hints
===========

These are some of the design and architecture requirements that an application 
has to fulfill in order to use the Room API:

- include the SDK module to its dependencies list
- create an instance of one of the two **Room Manager** types by 
  providing implementations for the following interfaces: 

  - ``RoomEventHandler``
  - ``KurentoClientProvider``

- develop the client-side of the application for devices that support WebRTC
  (*hint:* or use our **client-js** library and take a look at the demo's client 
  implementation)
- design a room signaling protocol that will be used between the clients and
  the server (*hint:* or use the WebSockets API from ``kurento-room-server``) 
- implement a handler for clients' requests on the server-side, that will
  use the ``RoomManager`` to process these requests (*hint:* JSON-RPC handler
  from ``kurento-room-server``)
- choose a response and notification mechanism for the communication with the
  clients (*hint:* JSON-RPC notification service from ``kurento-room-server``)

About the technology stacks that can or should be used to implement a Rooms 
application: 

- WebSockets for the communications between the server and the clients
- Spring and Spring Boot for the easy configuration and integration with some 
  of Kurento's modules. It also provides a WebSockets library.

And of course, the main requirement is at least one installation of the Kurento
Media Server, accessible to the room application.

Try the tutorial
================

There is :doc:`a complete tutorial <room_demo_tutorial>` on how to create a 
multi-conference application by taking advantage of the components already
provided in this project (Room SDK, Room Server and the JavaScript client). The
tutorial is based on the development of the Room Demo application.