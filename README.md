# JmsExample

JmsEmbeddedBroker is a standalone MQ Broker using Apache Activemq, listening on tcp://localhost:61616 , ready to receive JMS messages.

JmsPublisherConsumer contains a publisher , which can send messages to the standalone Broker, and also a consumer, to consume this messages.
On the publisher, the queue is created dynamically ( Queue queue = session.createQueue("test.queue"); ), in case this queue does not exists yet.
