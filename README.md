# MULTITHREADED-CHAT-APPLICATION

*COMPANY*: CODETECH IT SOLUTIONS

*NAME*: JITHESH T

*INTERN ID*: CT04DK730

*DOMAIN*: JAVA

*DURATION*: 4 WEEKS

*MENTOR*: NEELA SANTHOSH KUMAR 

## This multithreaded chat application is a client-server architecture where multiple users (clients) can connect to a single server and exchange messages in real-time. Here are some practical use cases:

    1. LAN-based Chat System
   We can use this app on a Local Area Network (like a college lab, office floor, or hostel) to let users chat without needing the internet.

    2. Customer Support Tools
   A simplified version of this system can be the backend for:

   .Customer support chat

   .Live help desk messaging

   .Internal IT support tools

    3. Gaming Chat Rooms
   Many multiplayer games have in-game chat, where players connect to a game server and send messages to each other.

    4. Learning Network Programming
   Used for

   .Students or developers learning TCP/IP sockets

   .Understanding multi-threading and I/O stream handling

   .Practicing concurrent client handling

    5. Embedded Systems / IoT Devices
   Lightweight devices can send simple text data (status updates, sensor messages, alerts) to a central server using this model.


    #Multithreaded Chat Application using Java Sockets

    Project Overview
   The Multithreaded Chat Application is a console-based real-time messaging system developed in Java that facilitates communication between multiple users over a network. The system is built using the client-server model, where a single server handles connections from multiple clients. Each client can send messages, which are then broadcasted to all other connected users. This system demonstrates the fundamentals of network programming, concurrent programming, and socket-based communication.

   The server continuously listens for incoming client connections on a specified port (1234 in this case). Once a client connects, the server creates a new thread dedicated to handling communication for that client. This is made possible using Java’s multithreading capabilities and the Runnable interface. Each thread reads messages from its respective client and broadcasts them to all other connected clients using synchronized data structures to prevent concurrency issues.

   The client, on the other hand, connects to the server socket, allows user input via the console, and continuously listens for incoming messages from the server in a background thread. It uses Java's BufferedReader and PrintWriter classes to manage input/output streams effectively.

    Tools & Technologies Used
  Java: Core language used for both client and server development.

  Java Sockets (java.net): For TCP-based communication between client and server.

  Multithreading (java.lang.Thread, Runnable): To handle multiple clients concurrently.

  Collections Framework (HashSet, Collections.synchronizedSet): For managing connected clients safely across threads.

  IntelliJ IDEA: Primary IDE used for writing and debugging the code.

  JDK 23: Java Development Kit used for compiling and running the application.

  Command Line (Terminal): Used for running client/server instances and observing communication.

    Use Cases

  LAN-based messaging systems: Ideal for schools, offices, and local environments without internet access.

  Educational platforms: Teaching students the practical implementation of client-server architecture and network protocols.

  Customer support simulation: Foundation for building real-time helpdesk or chatbots.

  Multiplayer games: Can serve as a basic chat engine between players.

  IoT device communication: Useful for devices that need to report to a central server via lightweight text protocols.

    Learning Outcomes

  Through building this project, I gained strong hands-on experience in:

  Socket programming and TCP/IP protocol

  Real-time communication systems

  Multithreaded application design

  Thread synchronization and concurrent data handling

  Debugging I/O and network-related exceptions

  This project lays a strong foundation for transitioning into more advanced areas like GUI-based chat systems, WebSocket communication, and asynchronous networking.


##OUTPUT
![Image](https://github.com/user-attachments/assets/691dc0be-7f8f-4c65-878c-d711af8b035b)
![Image](https://github.com/user-attachments/assets/b427d6a5-3a2b-416e-91c7-db92c1e6f09c)
