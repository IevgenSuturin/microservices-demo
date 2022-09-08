package com.ysuturin.microservices.demo.twittertokafkaservice;

import com.ysuturin.microservices.demo.twittertokafkaservice.init.StreamInitializer;
import com.ysuturin.microservices.demo.twittertokafkaservice.runner.StreamRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.ysuturin.microservices.demo")
public class TwitterToKafkaServiceApplication implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(TwitterToKafkaServiceApplication.class);

    private final StreamRunner streamRunner;
    private final StreamInitializer streamInitializer;

    public TwitterToKafkaServiceApplication(StreamRunner streamRunner,
                                            StreamInitializer streamInitializer) {
        this.streamRunner = streamRunner;
        this.streamInitializer = streamInitializer;
    }

    public static void main(String[] args) {
        SpringApplication.run(TwitterToKafkaServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Application runs...");
        streamInitializer.init();
        streamRunner.start();
    }
}