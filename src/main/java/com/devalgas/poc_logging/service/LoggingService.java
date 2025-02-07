package com.devalgas.poc_logging.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoggingService {
    private static final Logger LOG = LoggerFactory.getLogger(LoggingService.class);

    public String logMessage(String product, String user) {
        LOG.info("Nouvel invoice - ref: {}, title: {}", product, user);
        return "Log message generated for product: " + product + " and user: " + user;
    }
}
