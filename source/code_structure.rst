%%%%%%%%%%%%%%
Code structure
%%%%%%%%%%%%%%

Kurento Room is hosted on github:

https://github.com/Kurento/kurento-room

The git repository contains a Maven project with the following modules:

- `kurento-room <https://github.com/Kurento/kurento-room>`_ - reactor project
- `kurento-room/kurento-room-sdk <https://github.com/Kurento/kurento-room/tree/master/kurento-room-sdk>`_ - 
  module that provides a management interface for developers of multimedia 
  conferences (rooms) applications in Java.
- `kurento-room/kurento-room-server <https://github.com/Kurento/kurento-room/tree/master/kurento-room-server>`_ - 
  Kurento's own implementation of a room API, it provides the WebSockets API for 
  the communications between room clients and the server.
- `kurento-room/kurento-room-client <https://github.com/Kurento/kurento-room/tree/master/kurento-room-client>`_ - 
  Java library that uses WebSockets and JSON-RPC to interact with the server-side 
  of the Room API. Can be used to implement the client-side of a room application.
- `kurento-room/kurento-room-client-js <https://github.com/Kurento/kurento-room/tree/master/kurento-room-client-js>`_ - 
  Javascript library that acts as wrapper for several JS APIs (WebRTC, 
  WebSockets, Kurento Utils). Can be used to implement the client-side of a room 
  application.
- `kurento-room/kurento-room-demo <https://github.com/Kurento/kurento-room/tree/master/kurento-room-demo>`_ - 
  demonstration project, contains the client-side implementation (HTML, 
  Javascript, graphic resources) and embeds the room server to provide the 
  functionality required for group communications (the so-called rooms).
- `kurento-room/kurento-room-test <https://github.com/Kurento/kurento-room/tree/master/kurento-room-test>`_ - 
  includes integration tests for the room server application and the demo.
- `kurento-room/kurento-room-demo-test <https://github.com/Kurento/kurento-room/tree/master/kurento-room-demo-test>`_ - 
  includes integration tests for the demo application.
  