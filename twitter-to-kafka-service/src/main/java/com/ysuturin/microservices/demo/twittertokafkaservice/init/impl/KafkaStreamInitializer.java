package com.ysuturin.microservices.demo.twittertokafkaservice.init.impl;

import com.ysuturin.microservices.demo.config.KafkaConfigData;
import com.ysuturin.microservices.demo.kafka.admin.client.KafkaAdminClient;
import com.ysuturin.microservices.demo.twittertokafkaservice.init.StreamInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class KafkaStreamInitializer implements StreamInitializer {
    private static final Logger logger = LoggerFactory.getLogger(KafkaStreamInitializer.class);

    private final KafkaConfigData kafkaConfigData;
    private final KafkaAdminClient kafkaAdminClient;

    public KafkaStreamInitializer(KafkaConfigData kafkaConfigData,
                                  KafkaAdminClient kafkaAdminClient) {
        this.kafkaConfigData = kafkaConfigData;
        this.kafkaAdminClient = kafkaAdminClient;
    }

    @Override
    public void init() {
        kafkaAdminClient.createTopics();
        kafkaAdminClient.checkSchemaRegistry();
        logger.info("Topics with the name {} are ready for operations!", kafkaConfigData.getTopicNamesToCreate());
    }
}
