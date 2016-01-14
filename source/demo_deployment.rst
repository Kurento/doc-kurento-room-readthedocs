%%%%%%%%%%%%%%%
Demo deployment
%%%%%%%%%%%%%%%

This section explains how to install, configure and deploy the Room demo application 
and how to publish the API. 

On machines which meet the following requirements, one can install Kurento Room 
applications as a system service (e.g. ``kurento-room-demo``). There's also the 
possibility to manually run the demo using the provided script.

System requirements:

- Ubuntu 14.04
- JDK 7 or 8
- Maven
- Kurento Media Server or connection with at least a running instance (to
  install follow the official
  `guide <http://www.kurento.org/docs/current/installation_guide.html>`_)

Kurento room demo installer
===========================

Currently, there are no binary releases of Kurento Room Demo. In order to deploy 
a new demo server, it is needed to build it from sources.

Demo binaries
#############

The demo has been configured to generate a zipped archive during the *package* 
phase of a Maven build. To obtain it, build the **kurento-room-demo** project 
together with its required modules:

.. sourcecode:: bash

   $ cd kurento-room
   $ mvn clean package -Pdefault -am -pl kurento-room-demo

Now unzip the generated execution binaries (where ``x.y.z`` is the current 
version and could include the ``-SNAPSHOT`` suffix):

.. sourcecode:: bash

   $ cd kurento-room-demo/target
   $ unzip kurento-room-demo-x.y.z.zip


.. _server-configuration:

Configuration
#############

The configuration file, ``kroomdemo.conf.json`` is located in the ``config``
folder inside the uncompressed installation binaries. When installing the
demo application as a system service, the configuration files will be located 
inside ``/etc/kurento``.

.. sourcecode:: bash

   $ cd kurento-room-demo-x.y.z
   $ vim config/kroomdemo.conf.json
   ## or ##
   $ vim /etc/kurento/kroomdemo.conf.json

The default content of this file:

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
   
With the following key meanings:

- ``kms.uris`` is an array of WebSocket addresses used to initialize
  ``KurentoClient`` instances (each instance represents a Kurento Media Server). In
  the default configuration, for the same KMS the application will create two
  ``KurentoClient`` objects. The ``KurentoClientProvider`` implementation for this demo
  (``org.kurento.room.demo.FixedNKmsManager``) will return ``KurentoClient`` instances
  on a round-robin base or, if the user's name follows a certain pattern, will
  return the less loaded instance. The pattern check is hardcoded and SLA users
  are considered those whose name starts with the string special (e.g.
  *specialUser*).
- ``kurento.client.requestTimeout`` is a tweak to prevent timeouts in the KMS
  communications during heavy load (e.g. lots of peers). The default value of
  the timeout is 10 seconds.
- ``app.uri`` is the demo application's URL and is mainly used for building
  URLs of images used in media filters (such as the hat filter). This URL must
  be accessible from any KMS defined in ``kms.uris``.
- ``demo.hatUrl`` sets the image used for the ``FaceOverlayFilter`` applied to the
  streamed  media when the user presses the corresponding button in the demo
  interface. The filename of the image is relative to the static web
  resources folder ``img/``.
- ``demo.hatCoords`` represents the JSON encoding of the parameters required to
  configure the overlaid image. We provide the coordinates for two hat
  images, *mario-wings.png* and *wizard.png*.
- ``demo.loopback.remote`` if true, the users will see their own video using
  the loopbacked stream from the server. Thus, if the user enables the hat
  filter on her video stream, she'll be able to visualize the end result
  after having applied the filter.
- ``demo.loopback.andLocal`` if true, besides displaying the loopback media,
  the client interface will also provide the original (and local) media stream.
- ``demo.authRegex`` is the username pattern that allows the creation of a room
  only when it matches the pattern. This is done during the call to obtain an 
  instance of ``KurentoClient``, the provider will throw an exception if the 
  pattern has been specified and it doesn't match the name.
- ``demo.kmsLimit`` is the maximum number of pipelines that can be created in a
  ``KurentoClient``.

HTTPS
######

The application uses a Java keystore - ``keystore.jks`` - containing a 
self-signed certificate, which is located in the same folder as the JAR 
executable file.

The keystore's configuration is read from the ``application.properties`` file, a 
specific Spring Boot configuration file. 
Any changes like the keystore's name or password can be applied directly into 
this file.

These settings are read automatically by the application (not required to be on the
command line).

.. sourcecode:: json

   server.port: 8443
   server.address: 0.0.0.0
   server.ssl.key-store: keystore.jks
   server.ssl.key-store-password: kurento
   server.ssl.keyStoreType: JKS
   server.ssl.keyAlias: kurento-selfsigned

In order to disable HTTPS, remove or rename the file, or remove those lines that 
contain **ssl** and change the value of ``server.port`` to a more suitable value 
(recommended only if using a secure proxy with SSL).

``server.address`` is an IP address that tells the embedded Tomcat to bind 
to (default value is *0.0.0.0* where it listens on all available addresses).
It is useful when securing the application, by indicating the loopback IP and 
serving all connections through a secure proxy.

Logging configuration
#####################

The default logging configuration can be overwritten by editing the file 
``kroomdemo-log4j.properties``, also found in the ``config`` folder (or
``/etc/kurento`` for system-wide installations).

.. sourcecode:: bash

   $ cd kurento-room-demo-x.y.z
   $ vim config/kroomdemo-log4j.properties
   ## or ##
   $ vim /etc/kurento/kroomdemo-log4j.properties

In it, the location of the server's output log file can be set up, the default 
location will be ``kurento-room-demo-x.y.z/logs/`` (or ``/var/log/kurento/`` 
for system-wide installations).

To change it, replace the ``${kroomdemo.log.file}`` variable for an 
absolute path on your system:

.. sourcecode:: bash

   log4j.appender.file.File=${kroomdemo.log.file}

Running the application
=======================
After having built and unzipped the installation files, there are two options
for running the demo application server:

- **user-level execution** - doesn't need additional installation steps, can
  be done right away after uncompressing the installer
- **system-level execution** - requires installation of the demo application
  as a system service, which enables automatic startup after system reboots

In both cases, the application uses Spring Boot framework to run inside an
embedded Tomcat container server, so there's no need for deployment inside an
existing servlet container. If this is a requirement, modifications will have
to be made to the project's build configuration (Maven) so that instead of a
JAR with dependencies, the build process would generate a WAR file.

Run at user-level
#################

After having :ref:`configured <server-configuration>` the server instance just 
execute the start script: 

.. sourcecode:: bash

   $ cd kurento-room-demo-x.y.z
   $ ./bin/start.sh

Run as daemon
#############

First install the demo after having built and uncompressed the generated
binaries. **sudo** privileges are required to install it as a service:

.. sourcecode:: bash

   $ cd kurento-room-demo-x.y.z
   $ sudo ./bin/install.sh

The service **kroomdemo** will be automatically started.

Now, you can configure the Room demo server as stated in the 
:ref:`previous section <server-configuration>` and restart the service.

.. sourcecode:: bash
   
   $ sudo service kroomdemo {start|stop|status|restart|reload}

Troubleshooting
###############

For quickstarting and troubleshooting the demo use the following command to
execute the *fat jar* from the **lib** folder:

.. sourcecode:: bash

   $ cd kurento-room-demo-x.y.z/lib
   $ java -jar kurento-room-demo.jar

Version upgrade
###############

To update to a newer version, please repeat the installation procedures.
