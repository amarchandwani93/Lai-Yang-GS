### About System
1. P2P message passing distributed system. So message sent in a channel will be immediately consumed by destination process without much time delay, if it is up and running.
2. Each Process(Pi) in the system will have two channels between it and another process(Pj) (Send and Receive Channel)

### Algorithms
1. Lai-Yang Snapshot Algorithm
   #### Implementation :
   Each process is a background worker and can read data like event-loop. Depending on the channel type the messages are sent to the receiver process. 
   #### Steps :
    1. Enter no of process. (integer value)
    2. Enter Channel Type 
    3. Enter initial amount for all processes (you can choose to start with same or different amounts for each process)
    4. Select an operation to do message transfer, record global state, print state at a process
        1. To send White-Message
            1. Enter Source process ID
            2. Enter Destination process ID
            3. Enter Amount to send
        2. To send Red-Message/Take global snapshot
            * Enter process ID to record global snapshot
        3. To print last recorded snapshot to console
            * Enter process ID to get last recoreded snapshot
        4. Exit

#### Class
    Process -> Holds source & destination and read & write channels.
    LaiYangProcess -> Sub-class of Prcess, holds process color, all snapshots.
    
    Message -> Interface for Message
    DataMessage -> Generic Message
    LaiYangMessage -> Algorithm specific implementation where each messages are colored (RED/While)

    Channel -> Interface
    AbstractChannel -> Holds common resource requiments for FIF0 and non-FIFO channels
    FifoChannel -> Ordered message passing implementation (Guarantee order)
    NonFifoChannel -> Un-ordered message passing implementation
    
    Orchestration -> creates process and setup channels between them
    LaiYangOrchestration -> Allows to send colored message, prints global state snapshots from a process

### CHECK : LaiYangTester.java to test
    Extract the contents of the zip file on your local system
    if testing in Eclipse, import this project as a Maven project into eclipse by File -> Import. Click on Maven -> Existing Maven Projects. Select the folder you extracted the contents to usign browser button.
    Once the project is open in eclipse, right click on the root folder -> Run As -> Java Application. Select LaiYangTester - com.chandwani.amar.tester to run the application in console.

#### Minimum Requirements :
1. Any Operating System
2. JDK-7 or above