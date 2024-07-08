package springmicroservicesdemo.kafkaservice.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import springmicroservicesdemo.kafkaservice.dto.TaskPayload;

@Service
public class DemoJsonProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoJsonProducer.class);

    @Value("${spring.kafka.demo-topic.name}")
    private String demoTopicName;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(TaskPayload taskPayload) {
        LOGGER.info(String.format("Json message recived -> %s", taskPayload.toString()));

        Message<TaskPayload> message = MessageBuilder
                .withPayload(taskPayload)
                .setHeader(KafkaHeaders.TOPIC, demoTopicName)
                .build();

        kafkaTemplate.send(message);
    }
}
