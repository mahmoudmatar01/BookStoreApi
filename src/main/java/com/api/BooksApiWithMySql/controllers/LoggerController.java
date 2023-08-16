package com.api.BooksApiWithMySql.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logger")
public class LoggerController {

    Logger logger = LoggerFactory.getLogger(LoggerController.class);

    @GetMapping
    public String getLoggingMessages() {
        logger.trace("Log level: TRACE");
        logger.info("Log level: INFO");
        logger.debug("Log level: DEBUG");
        logger.error("Log level: ERROR");
        logger.warn("Log level: WARN");

        return "Hey! You can check the output in the logs";
    }

}
