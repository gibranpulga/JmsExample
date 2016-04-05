package embeddedBroker;

import org.apache.activemq.broker.BrokerService;

public final class EmbeddedBroker {

    private EmbeddedBroker() {
    }

    public static void main(String[] args) throws Exception {
        BrokerService broker = new BrokerService();
        broker.setUseJmx(true);
        broker.addConnector("tcp://localhost:61616");
        broker.start();

        // now lets wait forever to avoid the JVM terminating immediately
        Object lock = new Object();
        synchronized (lock) {
            lock.wait();
        }
    }
}