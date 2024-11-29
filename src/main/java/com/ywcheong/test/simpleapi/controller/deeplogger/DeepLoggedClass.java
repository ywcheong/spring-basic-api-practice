package com.ywcheong.test.simpleapi.controller.deeplogger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deep")
public class DeepLoggedClass {

    private final Logger logger = LoggerFactory.getLogger(DeepLoggedClass.class);

    @GetMapping("/logged")
    public String logged(){
        logger.debug("I make debug");
        logger.info("Also I make info");
        logger.warn("Plus I make warn");
        logger.error("Help I am dying");
        return "hi";
    }
}
