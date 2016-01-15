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

  - ``RoomHandler``
  - ``KurentoClientProvider``

- develop the client-side of the application for devices that support :term:`WebRTC`
  (*hint:* or use our **client-js** library and take a look at the demo's client 
  implementation)
- design a room signaling protocol that will be used between the clients and
  the server (*hint:* or use the :term:`WebSockets` API from ``kurento-room-server``) 
- implement a server-side handler for client messages, that will use the 
  ``RoomManager`` to process these requests (*hint:* we provide a :term:`JSON-RPC`
  handler in ``kurento-room-server``)
- choose a response and notification mechanism for the communication with the
  clients (*hint:* JSON-RPC notification service from ``kurento-room-server``)

About the technology stacks that can or should be used to implement a Rooms 
application: 

- :term:`WebSockets` as transport for messages between the server and the clients
  (and maybe :term:`JSON-RPC` for the messages format).
- :term:`Spring Boot` for the easy configuration and integration with some of 
  Kurento's modules. It also provides a WebSockets library.

And of course, the main requirement is at least one installation of the 
:term:`Kurento Media Server` that has to be accessible from the room application.

Try the tutorial
================

There is :doc:`a complete tutorial <room_demo_tutorial>` on how to create a 
multi-conference application by taking advantage of the components already
provided in this project (Room SDK, Room Server and the JavaScript client). The
tutorial is based on the development of the Room Demo application.