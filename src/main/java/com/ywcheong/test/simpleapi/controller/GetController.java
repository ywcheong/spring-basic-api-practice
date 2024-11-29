package com.ywcheong.test.simpleapi.controller;

import com.ywcheong.test.simpleapi.data.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/get-control")
public class GetController {
    // localhost/simple
    @GetMapping("/simple")
    public String simpleGet() {
        return "simple get";
    }

    // localhost/with-pathvar/1
    @GetMapping("/with-pathvar/{argint}")
    public String withPathvar(@PathVariable("argint") int argint) {
        return "with pathvar (argint=" + argint + ")";
    }

    // localhost/with-param?age=1
    @GetMapping("/with-param")
    public String withParam(@RequestParam("argint") int argint) {
        return "with param (argint=" + argint + ")";
    }

    @GetMapping("/with-dynamic-param")
    public String withDynamicParam(@RequestParam Map<String, String> param) {
        StringBuffer sb = new StringBuffer();
        sb.append("arguments {");

        param.forEach((key, value) -> sb.append(key).append("=").append(value).append(","));

        sb.append("}");
        return sb.toString();
    }

    @GetMapping("/with-dto")
    public String withDto(MemberDto memberDto) {
        return "with dto(member=" + memberDto.toString() + ")";
    }
}
