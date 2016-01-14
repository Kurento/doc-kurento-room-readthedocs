%%%%%%%%%%%
Quick start
%%%%%%%%%%%

Running the demo
----------------

For a quick initial contact with the framework, we recommend running the demo
application and observing the exchange of Websocket messages between the clients
and the server. 

Currently, the demo is only supported for Ubuntu 14.04 LTS 64bits.

After cloning the tutorial, it can be executed directly from the terminal by 
using Maven's ``exec`` plugin. To make sure the demo can be built and executed 
correclty, a stable release (or tag) is checked out before proceeding with the 
build (prevents missing dependencies, given that in Kurento **master** is the 
development branch):

.. sourcecode:: bash

   $ git clone git@github.com:Kurento/kurento-room.git
   $ cd kurento-room
   # checkout the latest tag
   $ git checkout $(git describe --abbrev=0 --tags)
   $ cd kurento-room-demo
   $ mvn compile exec:java

Now open the following URL in a WebRTC-compatible browser and connect to a new
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
KMS instance when creating the ``KurentoClient`` required by the Room API.

More details on the demo's configuration and execution can be found in the
:doc:`deployment </demo_deployment>` section.