package com.lehua.transaction_api.services;


import com.lehua.common.model.TransactionDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;


@Service
public class TransactionProducer {

    private final KafkaTemplate<String, TransactionDto> kafkaTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionProducer.class);

    public TransactionProducer(KafkaTemplate<String, TransactionDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(TransactionDto transaction) {

        Message<TransactionDto> message = MessageBuilder
                .withPayload(transaction)
                .setHeader(KafkaHeaders.TOPIC, "transactions")
                .build();

        kafkaTemplate.send(message);
        LOGGER.info("Published transaction: " + transaction);
    }
}
