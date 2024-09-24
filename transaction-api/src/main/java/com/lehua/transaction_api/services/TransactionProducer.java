package com.lehua.transaction_api.services;

import com.lehua.common.dtos.TransactionDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;


@Service
public class TransactionProducer {

    private final KafkaTemplate<String, TransactionDTO> kafkaTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionProducer.class);

    public TransactionProducer(KafkaTemplate<String, TransactionDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(TransactionDTO transaction) {

        Message<TransactionDTO> message = MessageBuilder
                .withPayload(transaction)
                .setHeader(KafkaHeaders.TOPIC, "transactions")
                .build();

        kafkaTemplate.send(message);

        LOGGER.info("SENT TRANSACTION: " + transaction.toString());
    }
}
