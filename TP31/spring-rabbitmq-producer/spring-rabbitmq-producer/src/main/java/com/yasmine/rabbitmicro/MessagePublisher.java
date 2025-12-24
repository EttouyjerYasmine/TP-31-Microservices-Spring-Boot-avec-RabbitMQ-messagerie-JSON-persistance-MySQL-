package com.yasmine.rabbitmicro;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.UUID;

@RestController
public class MessagePublisher {

    @Autowired
    private RabbitTemplate template;

    @PostMapping("/publish")
    public String publishMessage(@RequestBody CustomMessage message) {
        // Générer un ID unique et la date
        message.setMessageId(UUID.randomUUID().toString());
        message.setMessageDate(new Date());

        // Publier le message
        template.convertAndSend(MQConfig.EXCHANGE, MQConfig.ROUTING_KEY, message);

        System.out.println("✅ Message publié : " + message);
        return "Message Published à : " + new Date();
    }
}