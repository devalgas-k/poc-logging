package com.devalgas.poc_logging.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

@RestController
public class LoggingRest {

    private static final Logger LOG = LoggerFactory.getLogger(LoggingRest.class);

    @GetMapping
    public String logMessage() {
        LOG.trace("Nouvel achat - Produit: {}, Utilisateur: {}", "SGGS", "SSS");

        return "Log message generated";
    }
}
