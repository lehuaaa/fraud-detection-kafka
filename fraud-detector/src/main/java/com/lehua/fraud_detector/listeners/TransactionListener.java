package com.lehua.fraud_detector.listeners;

import com.lehua.common.model.TransactionDto;
import com.lehua.fraud_detector.services.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TransactionListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionListener.class);

    private final TransactionService transactionService;

    public TransactionListener(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @KafkaListener(topics = "transactions", groupId = "consumer")
    public void consume(TransactionDto transaction) {
        LOGGER.info("Consumed transaction: " + transaction);
        this.transactionService.save(transaction);
    }

}
