package test.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Sender {
	private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);
	
	@Value("${abc.messagem}")
	private String messagem;

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void send(String payload) {
		LOGGER.info("sending payload='{}'", payload);
		kafkaTemplate.send("helloworld.t", payload);
		
		System.out.println("==================================================");
		System.out.println("**************************************************");
		System.out.println(messagem);
		System.out.println("**************************************************");
		System.out.println("==================================================");
	}
}
