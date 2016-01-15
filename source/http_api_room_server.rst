%%%%%%%%%
REST APIs
%%%%%%%%%

Apart from the :term:`WebSocket` API, clients can also interact with the Room Server 
component using a more conventional :term:`Http` :term:`REST` API. 

Room Server API
===============

The Room Server component publishes a REST service with only one primitive,
that can be used to obtain the available rooms.

1 - Get all rooms
-----------------

Returns a list with all the available rooms' names.

- **Request method and URL**: ``GET /getAllRooms``
- **Request Content-Type**: NONE
- **Request parameters**: NONE
- **Response elements**: Returns an entity of type ``application/json`` including
  a *POJO* of type ``Set<String>`` with the following information:

+---------+----------+---------------------------------+
| Element | Optional | Description                     |
+---------+----------+---------------------------------+
| roomN   | Yes      | Name of the N-th available room |
+---------+----------+---------------------------------+

- **Response Codes**

+--------+-----------------------------+
| Code   | Description                 |
+--------+-----------------------------+
| 200 OK | Query successfully executed |
+--------+-----------------------------+

Room Demo API
=============

The demo application provides an additional REST service with two primitives:
 
 - close a given room directly from the server and evict the existing participants 
 - one that sends the configuration loopback parameters to the client-side

1 - Close room
--------------

Closes the room

- **Request method and URL**: ``GET /close?room={roomName}``
- **Request Content-Type**: NONE
- **Request parameters**:

+------------+----------+--------------------------------------+
| Element    | Optional | Description                          |
+------------+----------+--------------------------------------+
| {roomName} | No       | Name of the room that will be closed |
+------------+----------+--------------------------------------+

- **Response elements**:

+---------------+---------------------------------------+
| Code          | Description                           |
+---------------+---------------------------------------+
| 200 OK        | Query successfully executed           |
+---------------+---------------------------------------+
| 404 Not found | No room exists with the provided name |
+---------------+---------------------------------------+

2 - Get client configuration
----------------------------

Returns a ``ClientConfig`` *POJO* that can be used to configure the source for the own
video (only local, remote or both).

- **Request method and URL**: ``GET /getClientConfig``
- **Request Content-Type**: NONE
- **Request parameters**: NONE
- **Response elements**: Returns an entity of type ``application/json`` including
  a *POJO* of type ``ClientConfig`` with the following information:

+------------------+----------+---------------------------------------------------------------------+
| Element          | Optional | Description                                                         |
+------------------+----------+---------------------------------------------------------------------+
| loopbackRemote   | Yes      | If true, display the local video from the server loopback           |
+------------------+----------+---------------------------------------------------------------------+
| loopbackAndLocal | Yes      | If the other parameter is true, enables the original source as well |
+------------------+----------+---------------------------------------------------------------------+

- **Response Codes**:

+--------+-----------------------------+
| Code   | Description                 |
+--------+-----------------------------+
| 200 OK | Query successfully executed |
+--------+-----------------------------+
