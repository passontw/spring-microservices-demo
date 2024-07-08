package springmicroservicesdemo.kafkaservice.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;
import springmicroservicesdemo.kafkaservice.dto.TaskPayload;

@Service
public class DemoJsonConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoJsonProducer.class);

    @KafkaListener(
            topics = "${spring.kafka.demo-topic.name}",
            groupId = "myGroup"
    )
//    public void demoConsumer(ConsumerRecord<String, TaskPayload> taskPayload) {
    public void demoConsumer(ConsumerRecord<String, TaskPayload> taskPayload, Acknowledgment ack) {
        LOGGER.info("==============demoConsumer start===============");
        LOGGER.info(String.format("Json message recived -> %s", taskPayload.toString()));
        ack.acknowledge();
        LOGGER.info("==============demoConsumer end===============");
    }
}
