import ballerina/jms;
import ballerina/io;

// Initialize a JMS connection with the provider
jms:Connection jmsConnection = new ({
        initialContextFactory: "bmbInitialContextFactory",
        providerUrl: "amqp://admin:admin@carbon/carbon?brokerlist='tcp://localhost:5772'"
    });

// Initialize a JMS session on top of the created connection
jms:Session jmsSession = new (jmsConnection, {
        acknowledgementMode: "AUTO_ACKNOWLEDGE"
    });

jms:QueueSender queueSender = new(jmsSession, queueName = "MyQueue4");

public function main () {
    // Create a Text message.
    var msg = jmsSession.createTextMessage("Test Text");
    if (msg is jms:Message) {
         // Send the Ballerina message to the JMS provider.
         _ = queueSender->send(msg);
    } else {
         panic msg;
    }

    io:println("Message successfully sent by QueueSender");
}
