package publisher;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class PublisherJava {
	
	public static void main(String[] args) throws JMSException {
		ConnectionFactory factory = 
				  new ActiveMQConnectionFactory("tcp://localhost:61616");  // ActiveMQ-specific (more)

				Connection con = factory.createConnection();

				try {
				  Session session = 
				      con.createSession(false, Session.AUTO_ACKNOWLEDGE);  // non-transacted session (more)

				  Queue queue = session.createQueue("test.queue");         // only specifies queue name (more)

				  MessageProducer producer = session.createProducer(queue);
				  System.out.println("Sending message");
				  Message msg = session.createTextMessage("hello queue");  // text message (more)
				  producer.send(msg);
				  session.close();
				}
				finally {
				  con.close();                                             // free all resources (more)
				}
	}
}