package com.lehua.malicious_subscriber.listeners;

import com.lehua.common.model.TransactionDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TransactionListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionListener.class);

    @KafkaListener(topics = "transactions", groupId = "consumer")
    public void consume(TransactionDto transaction) {
        LOGGER.info("Consumed transaction: " + transaction);
    }

}
