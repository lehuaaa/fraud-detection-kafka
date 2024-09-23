package com.lehua.transaction_api;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TransactionsTopicConfig {

    @Bean
    public NewTopic transactionsTopic() {
        return TopicBuilder
                .name("transactions")
                .partitions(3)
                .replicas(3)
                .build();
    }

}
