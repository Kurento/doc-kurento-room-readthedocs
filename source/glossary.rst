%%%%%%%%
Glossary
%%%%%%%%

This is a glossary of terms that often appear in discussion about multimedia
transmissions. Most of the terms are described and linked to its wikipedia, RFC
or W3C relevant documents. Some of the terms are specific to :term:`kurento`.


.. glossary::
    AngularJS
        Represents an open-source web application framework that tries to address 
        many of the challenges encountered in developing single-page applications.
        Provides a framework for client-side model–view–controller (MVC) and 
        model–view–viewmodel (MVVM) architectures, along with components commonly 
        used in rich Internet applications.
        
        .. seealso:: `AngularJS home page <https://angularjs.org/>`_
    
    Bower
        `Bower <http://bower.io/>`_ is a package manager for the web.
        It offers a generic solution to the problem of front-end package management,
        while exposing the package dependency model via an API that can be consumed by
        a build stack.
    
    getUserMedia
        The ``getUserMedia()`` JavaScript method is related to WebRTC because 
        it's the gateway into that set of APIs. It provides the means to access 
        the user's local camera/microphone stream.
        
         .. seealso::
            ``getUserMedia`` from the `MediaDevices interface <https://developer.mozilla.org/en-US/docs/Web/API/MediaDevices/getUserMedia>`_
            
            ``getUserMedia`` from the `Navigator interface <https://developer.mozilla.org/en-US/docs/Web/API/Navigator/getUserMedia>`_ (*deprecated*)
           
                
    Git
        `Git <http://git-scm.com/>`_ is a free and open source distributed 
        version control system designed to handle everything from small to very 
        large projects with speed and efficiency.
        
        .. seealso::
            :wikipedia:`Git_(software)`
                Wikipedia reference of Git

    GitHub
        `GitHub <https://github.com/>`_ is a Web-based :term:`Git` repository 
        hosting service.
        
        .. seealso::
            :wikipedia:`GitHub`
                Wikipedia reference of GitHub

    HTTP
        The :wikipedia:`Hypertext Transfer Protocol <en,Hypertext_Transfer_Protocol>`
        is an application protocol for distributed, collaborative, hypermedia
        information systems. HTTP is the foundation of data communication for
        the World Wide Web.

        .. seealso:: :rfc:`2616`

    ICE
    Interactive Connectivity Establishment
        Interactive Connectivity Establishment (ICE) is a technique used to achieve
        :term:`NAT Traversal`. ICE makes use of the :term:`STUN` protocol and its extension,
        :term:`TURN`. ICE can be used by any protocol utilizing the offer/answer model.

        .. seealso::
            :rfc:`5245`

            :wikipedia:`en,Interactive Connectivity Establishment`
                Wikipedia reference of ICE

    JSON
        `JSON <http://json.org>`__ (JavaScript Object Notation) is a lightweight
        data-interchange format. It is designed to be easy to understand and
        write for humans and easy to parse for machines.

    JSON-RPC
        `JSON-RPC <http://json-rpc.org/>`__ is a simple remote procedure
        call protocol encoded in JSON. JSON-RPC allows for notifications
        and for multiple calls to be sent to the server which may be
        answered out of order.

    Kurento
        `Kurento <http://kurento.org>`__ is a platform for the development of multimedia
        enabled applications. Kurento is the Esperanto term for the English word
        'stream'. We chose this name because we believe the Esperanto principles are
        inspiring for what the multimedia community needs: simplicity, openness and
        universality. Kurento is open source, released under LGPL 2.1, and has several
        components, providing solutions to most multimedia common services
        requirements. Those components include: :term:`Kurento Media Server`,
        :term:`Kurento API`, :term:`Kurento Protocol`, and :term:`Kurento Client`.

    Kurento API
         **Kurento API** is an object oriented API to create media pipelines to control
         media. It can be seen as and interface to Kurento Media Server. It can be used from the
         Kurento Protocol or from Kurento Clients.

    KurentoClient
    Kurento Client
         A **Kurento Client** is a programming library (Java or JavaScript) used to control
         **Kurento Media Server** from an application. For example, with this library, any developer
         can create a web application that uses Kurento Media Server to receive audio and video from
         the user web browser, process it and send it back again over Internet. Kurento Client
         exposes the :term:`Kurento API <Kurento API>` to app developers.

    Kurento Protocol
         Communication between KMS and clients by means of :term:`JSON-RPC` messages.
         It is based on :term:`WebSocket` that uses :term:`JSON-RPC` V2.0 messages for making
         requests and sending responses.

    Kurento Utils
         The Kurento Utils for Node.js and Browsers project contains a set of 
         reusable components that have been found useful during the development 
         of the WebRTC applications with Kurento.
         
         .. seealso:: `GitHub repository page <https://github.com/kurento/kurento-utils-js>`_

    KMS
    Kurento Media Server
         **Kurento Media Server** is the core element of Kurento since it responsible for media
         transmission, processing, loading and recording.
    
    lumx
         A responsive front-end framwework based on AngularJS and Google Material 
         Design specifications. It provides a full CSS Framework built with 
         Sass and a bunch of AngularJS components.
         
         .. seealso:: `lumX page <http://ui.lumapps.com/>`_
    
    Maven
        `Maven <http://maven.apache.org/>`_ is a build automation tool used primarily for Java projects.

    Media Element
    Media Elements
        A :java:type:`MediaElement` is a module that encapsulates a specific
        media capability.  For example, a :java:type:`RecorderEndpoint`,
        a Video :java:type:`PlayerEndpoint`

    Media Pipeline
        A :index:`Media Pipeline <single: Media; Pipeline>` is a chain of media elements, where the output
        stream generated by one element (source) is fed into one or
        more other elements input streams (sinks). Hence, the pipeline
        represents a “machine” capable of performing a sequence of
        operations over a stream.

    Media Plane
        In the traditional :wikipedia:`3GPP Mobile Carrier Media Framework
        <en,IP_Multimedia_Subsystem>`, the handling of media is conceptually
        splitted in two layers.
        The one that handles the media itself, with functionalities such as
        media transport, encoding/decoding, and processing, is called
        :index:`Media Plane <single: Plane; Media>`.

        .. seealso:: :term:`Signaling Plane`
        
    Multimedia
        Multimedia is concerned with the computer controlled integration
        of text, graphics, video, animation, audio, and any other media where
        information can be represented, stored, transmitted and processed
        digitally.

        There is a temporal relationship between many forms of media,
        for instance audio, video and animations. There 2 are forms of problems
        involved in

            * Sequencing within the media, i.e. playing frames in correct
              order or time frame.
            * Synchronisation, i.e. inter-media scheduling. For example,
              keeping video and audio synchronized or displaying captions
              or subtitles in the required intervals.

        .. seealso:: Wikipedia definition of :wikipedia:`en,Multimedia`

    NAT
    Network Address Translation
        Network address translation (NAT) is the technique of modifying
        network address information in Internet Protocol (IP) datagram
        packet headers while they are in transit across a traffic routing
        device for the purpose of remapping one IP address space into
        another.

        .. seealso::

            :wikipedia:`Network Address Translation
            <en,Network_address_translation>`
            definition at Wikipedia

    NAT-T
    NAT Traversal
        NAT traversal (sometimes abbreviated as NAT-T) is a general term
        for techniques that establish and maintain Internet protocol
        connections traversing network address translation (NAT) gateways,
        which break end-to-end connectivity. Intercepting and modifying
        traffic can only be performed transparently in the absence of
        secure encryption and authentication.

        .. seealso::

            `NAT Traversal White Paper <http://www.nattraversal.com/>`_
                White paper on NAT-T and solutions for end-to-end
                connectivity in its presence
        
    Node.js
        `Node.js <http://www.nodejs.org/>`_ is a cross-platform runtime environment for server-side
        and networking applications. Node.js applications are written in
        JavaScript, and can be run within the Node.js runtime on OS X,
        Microsoft Windows and Linux with no changes.
    
    REST
        :wikipedia:`Representational State Transfer <en,Representational_state_transfer>`
        is an architectural style consisting of a coordinated set of constraints applied to
        components, connectors, and data elements, within a distributed hypermedia system.
        The term representational state transfer was introduced and defined in 2000 by
        Roy Fielding in his `doctoral dissertation
        <http://www.ics.uci.edu/~fielding/pubs/dissertation/rest_arch_style.htm>`__.

    RTCP
        The :wikipedia:`RTP Control Protocol <en,RTP_Control_Protocol>` is a
        sister protocol of the :term:`RTP`, that provides out-of-band
        statistics and control information for an RTP flow.

        .. seealso:: :rfc:`3605`

    RTCPeerConnection
        This interface represents a WebRTC connection between the local computer 
        and a remote peer. It is used to handle efficient streaming of data 
        between the two peers.

    RTP
        The :wikipedia:`Real-Time Transport Protocol <en,Real-time_Transport_Protocol>`
        is a standard packet format designed for transmitting audio and video
        streams on IP networks. It is used in conjunction with the
        :term:`RTP Control Protocol <RTCP>`. Transmissions using
        :wikipedia:`the RTP audio/video profile <en,RTP_audio_video_profile>`
        typically use :term:`SDP` to describe the technical parameters of
        the media streams.

        .. seealso:: :rfc:`3550`

    SDP
    Session Description Protocol
        The :wikipedia:`Session Description Protocol
        <en,Session_Description_Protocol>` describes initialization
        parameters for a streaming media session.
        Both parties of a streaming media session exchange SDP files
        to negotiate and agree in the parameters to be used for the
        streaming.

        .. seealso::

            :rfc:`4566`
                Definition of Session Description Protocol
            :rfc:`4568`
                Security Descriptions for Media Streams in SDP

    Signaling Plane
        It is the layer of a media system in charge of the information exchanges
        concerning the establishment and control of the different media circuits
        and the management of the network, in contrast to the transfer of media,
        done by the :index:`Signaling Plane <single: Plane; Signaling>`.

        Functions such as media negotiation, QoS parametrization, call establishment,
        user registration, user presence, etc. as managed in this plane.

        .. seealso:: :term:`Media Plane`

    SIP
        :wikipedia:`Session Initiation Protocol <en,Session_Initiation_Protocol>`
        is a `signaling plane`:term: protocol widely used for controlling
        multimedia communication sessions such as voice and video calls
        over Internet Protocol (IP) networks. SIP works in conjunction with
        several other application layer protocols:

        * `SDP`:term: for media identification and negotiation
        * `RTP`:term:, `SRTP`:term: or `WebRTC`:term: for the transmission of media streams
        * A `TLS`:term: layer may be used for secure transmission of SIP messages

    SPA
    Single-Page Application
       A single-page application is a web application that fits on a single web page with the goal
       of providing a more fluid user experience akin to a desktop application.

    Sphinx
        Documentation generation system used for Kurento projects.

        .. seealso:: 
          `Official Sphinx page <http://sphinx-doc.org/>`_
          
          `Easy and beautiful documentation with Sphinx <http://www.ibm.com/developerworks/linux/library/os-sphinx-documentation/index.html?ca=dat>`_

    SpringBoot
    Spring Boot
        `Spring Boot <http://projects.spring.io/spring-boot/>`_ is Spring's convention-over-configuration
        solution for creating stand-alone, production-grade Spring based applications that can you can "just run".
        It embeds Tomcat or Jetty directly and so there is no need to deploy WAR files in order to run
        web applications.

    SRTCP
        SRTCP provides the same security-related features to RTCP,
        as the ones provided by SRTP to RTP. Encryption, message
        authentication and integrity, and replay protection are the
        features added by SRTCP to `RTCP`:term:.

        .. seealso:: :term:`SRTP`

    SRTP
        :wikipedia:`Secure RTP <en,Secure_Real-time_Transport_Protocol>`
         is a profile of RTP (`Real-time Transport Protocol <RTP>`:term:),
         intended to provide encryption, message authentication and integrity,
         and replay protection to the RTP data in both unicast and multicast
         applications. Similar to how RTP has a sister RTCP protocol, SRTP
         also has a sister protocol, called Secure RTCP (or `SRTCP`:term:);

        .. seealso::
            :rfc:`3711`
            
    STUN
    Session Traversal Utilities for NAT
        STUN is a standardized set of methods to allow an end host to discover
        its public IP address if it is located behind a :term:`NAT`. STUN is a
        client-server protocol returning the public IP address to a client
        together with information from which the client can infer the type
        of NAT it sits behind.

    Trickle ICE
        Extension to the :term:`ICE` protocol that allows ICE agents to send and receive
        candidates incrementally rather than exchanging complete lists. With such
        incremental provisioning, ICE agents can begin connectivity checks while they
        are still gathering candidates and considerably shorten the time necessary for
        ICE processing to complete.

        .. seealso:: `Trickle ICE IETF Draft <https://tools.ietf.org/html/draft-ietf-mmusic-trickle-ice-02>`_

    TLS
        :wikipedia:`Transport Layer Security <en,Transport_Layer_Security>`
        and its prececessor Secure Socket Layer (SSL)

        .. seealso::
            :rfc:`5246`
                Version 1.2 of the Transport Layer Security protocol

    TURN
    Traversal Using Relays around NAT
        TURN is a protocol that allows for a client behind a :term:`NAT` or
        firewall to receive incoming data over TCP or UDP connections. TURN
        places a third party server to relay messages between two clients
        where peer to peer media traffic is not allowed by a firewall.

    User Agent
        Software agent that is acting on behalf of a user.
        
        .. seealso:: 
            :wikipedia:`User agent <en,User_agent>`

    WebRTC
        `WebRTC <http://www.webrtc.org/>`__ is an open source project that
        provides rich Real-Time Communcations capabilities to web browsers
        via Javascript and HTML5 APIs and components. These APIs are being
        drafted by the World Wide Web Consortium (W3C).

        .. seealso:: `WebRTC Working Draft <http://www.w3.org/TR/webrtc/>`__

    WebSocket
    WebSockets
        `WebSocket <https://www.websocket.org/>`__ specification (developed as
        part of the HTML5 initiative) defines a full-duplex single socket
        connection over which messages can be sent between client and server.
