package com.lehua.fraud_detector;

import com.lehua.common.dtos.TransactionDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

public class TransactionConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionConsumer.class);

    @KafkaListener(
            topics = "transactions",
            groupId = "detector"
    )
    public void consume(TransactionDTO transaction) {
        LOGGER.info("Consumed transaction: " + transaction.toString());
    }

}
