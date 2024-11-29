package com.ywcheong.test.simpleapi.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entity-control")
public class ResponseEntityController {

    // PUT /entity-control/echo?code=302&message=Hello+World
    @PutMapping("/echo")
    public ResponseEntity<String> statucCodeEcho(@RequestParam int code, @RequestParam String message) {
        return ResponseEntity.status(HttpStatusCode.valueOf(code)).body(message);
    }
}
