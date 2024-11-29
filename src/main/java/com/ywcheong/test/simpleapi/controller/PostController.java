package com.ywcheong.test.simpleapi.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/post-control")
public class PostController {
    @PostMapping("/with-body")
    public String withBody(@RequestBody(required = false) Map<String, String> body){
        if (body == null){
            return "null body";
        }

        StringBuffer sb = new StringBuffer();
        sb.append("Body <");
        body.forEach((key, value) -> sb.append(key).append(":").append(value).append(","));
        sb.append(">");
        return sb.toString();
    }
}
