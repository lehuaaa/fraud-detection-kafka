package com.lehua.fraud_detector.listeners;

import com.lehua.common.dtos.TransactionDTO;
import com.lehua.fraud_detector.services.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

public class TransactionConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionConsumer.class);

    private final TransactionService transactionService;

    public TransactionConsumer(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @KafkaListener(topics = "transactions", groupId = "detector")
    public void consume(TransactionDTO transaction) {
        LOGGER.info("Consumed transaction: " + transaction.toString());
        this.transactionService.save(transaction);
    }

}
