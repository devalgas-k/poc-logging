package com.devalgas.poc_logging.rest;

import com.devalgas.poc_logging.service.LoggingService;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Map;

@RestController
public class LoggingRest {

    private static final Logger LOG = LoggerFactory.getLogger(LoggingRest.class);
    private final LoggingService loggingService;

    public LoggingRest(LoggingService loggingService) {
        this.loggingService = loggingService;
    }

    @GetMapping
    public String logMessage() throws IOException {

        String product = RandomStringUtils.randomAlphabetic(5);
        String user = RandomStringUtils.randomAlphabetic(8);
/*        MDC.put("product", product);
        MDC.put("user", user);*/
        LOG.trace("Nouvel achat - Produit: {}, Utilisateur: {}", product, user);
/*        String date = LocalDate.now().format(DateTimeFormatter.ISO_DATE);
        String newFileName = String.format("logs/purchase-%s-%s-%s.log", date, product, user);
        Files.copy(Paths.get("logs/purchase.log"), Paths.get(newFileName), StandardCopyOption.REPLACE_EXISTING);
        MDC.clear();*/

        return loggingService.logMessage(product, user);
    }
}
