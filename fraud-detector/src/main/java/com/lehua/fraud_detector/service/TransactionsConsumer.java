package com.lehua.fraud_detector.service;

import com.lehua.common.dtos.TransactionDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TransactionsConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionsConsumer.class);

    @KafkaListener(
            topics = "transactions",
            groupId = "detector"
    )
    public void consume(TransactionDTO transaction) {
        LOGGER.info("CONSUMED TRANSACTION: " + transaction.toString());
    }

}
