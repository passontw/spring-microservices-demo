package springmicroservicesdemo.kafkaservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springmicroservicesdemo.kafkaservice.dto.TaskPayload;
import springmicroservicesdemo.kafkaservice.kafka.DemoJsonProducer;

@RestController
@AllArgsConstructor
@RequestMapping("/api/kafka-tasks")
public class KafkaTaskController {

    @Autowired
    private DemoJsonProducer demoJsonProducer;

    @GetMapping
    public ResponseEntity<String> getKafkaTask() {
        return new ResponseEntity<String>("Get Kafka Task", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> appendKafkaTask(@RequestBody TaskPayload taskPayload) {
        demoJsonProducer.sendMessage(taskPayload);
        return new ResponseEntity<String>("Append Kafka Task", HttpStatus.OK);
    }
}
