%%%%%%%%%%%
Quick start
%%%%%%%%%%%

For a quick initial contact with the framework, we recommend running the demo
application and observing the exchange of :term:`WebSocket` messages between the clients
and the server. 

Currently, the demo is only supported for Ubuntu 14.04 LTS 64bits.

Functionalities
---------------

This project, named **kurento-room-demo**, contains the client-side implementation
(HTML, JavaScript, graphic resources) of the Rooms API and embeds the room
server to provide the functionality required for group communications (the
so-called rooms).

Upon launch and using the :term:`SpringBoot` framework, it starts the main application 
of the module **kurento-room-server** which exposes the rooms API through an 
WebSocket interface. 

The client part has been implemented using :term:`AngularJS` and :term:`lumX` and it's using 
the room's JavaScript library for the client-side (``KurentoRoom.js``).

This application allows web clients to:

- login inside a room (creating the room if it doesn't exist)
- leave the room
- publish their media stream
- mute their video and/or audio
- enter fullscreen
- automatically subscribe to any stream published in the room and play it on
  the screen (video) and through the system speakers (audio)
- unsubscribe from a stream
- unpublish their media
- send messages to the other peers
- apply or remove a media filter over their published video stream (using a
  face overlay filter that adds a hat on top of a recognized human face)
- select which video source to display in the larger area of the browser from
  the available thumbnails

Running the demo
----------------

After cloning the tutorial, it can be executed directly from the terminal by 
using the :term:`Maven` ``exec`` plugin. To make sure the demo can be built and executed 
correctly, a stable release (or tag) is checked out before proceeding with the 
build (prevents missing dependencies, given that in :term:`Kurento` **master** is the 
development branch):

.. sourcecode:: bash

   $ git clone https://github.com/Kurento/kurento-room.git
   $ cd kurento-room
   # checkout the latest tag
   $ git checkout $(git describe --abbrev=0 --tags)
   $ cd kurento-room-demo
   $ mvn compile exec:java

Now open the following URL in a :term:`WebRTC`-compatible browser and connect to a new
room by providing the desired user and room names: https://localhost:8443.

Configuring the demo
--------------------

There are a couple of interesting options or properties that might have to be
modified for the demo to function properly.

The properties file, **kroomdemo.conf.json**, used in the demo's execution as 
described above, is located in the folder ``src/main/resources`` and its 
contents are the following:

.. sourcecode:: json

   {
      "kms": {
         "uris": ["ws://localhost:8888/kurento", "ws://127.0.0.1:8888/kurento"]
      },
      "app": {
         "uri": "https://localhost:8443/"
      },
      "kurento": {
         "client": {
            //milliseconds
            "requestTimeout": 20000
         }
      },
      "demo": {
         //mario-wings.png or wizard.png
         "hatUrl": "mario-wings.png",
         "hatCoords": {
            // mario-wings hat
            "offsetXPercent": -0.35F,
            "offsetYPercent": -1.2F,
            "widthPercent": 1.6F,
            "heightPercent": 1.6F
            
            //wizard hat
            //"offsetXPercent": -0.2F,
            //"offsetYPercent": -1.35F,
            //"widthPercent": 1.5F,
            //"heightPercent": 1.5F
         },
         "loopback" : {
            "remote": false,
            //matters only when remote is true
            "andLocal": false
         },
         "authRegex": ".*",
         "kmsLimit": 1000
      }
   }

These properties can be overwritten on the command-line when starting 
the demo server:

.. sourcecode:: bash

   $ mvn compile exec:java -Dkms.uris=[\"ws://192.168.1.99:9001/kurento\"]

In this example, we've instructed the demo to use a different URI of a running 
:term:`KMS` instance when creating the :term:`KurentoClient` required by the Room API.

More details on the demo's configuration and execution can be found in the
:doc:`deployment </demo_deployment>` section.