package com.ysuturin.microservices.demo.twittertokafkaservice.runner;

import twitter4j.TwitterException;

public interface StreamRunner {
    void start() throws TwitterException;
}
