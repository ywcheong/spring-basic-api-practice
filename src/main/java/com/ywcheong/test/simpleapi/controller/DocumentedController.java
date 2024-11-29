package com.ywcheong.test.simpleapi.controller;

import com.ywcheong.test.simpleapi.data.dto.MemberDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/documented")
public class DocumentedController {

    private final Logger logger = LoggerFactory.getLogger(DocumentedController.class);

    @PostMapping("/member-echo")
    @Operation(summary = "Member를 받아서 그대로 돌려줌")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "응답에 성공함", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MemberDto.class))
            }),
            @ApiResponse(responseCode = "204", description = "빈 요청을 받아 응답에 성공함", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MemberDto.class))
            })
    })
    public ResponseEntity<MemberDto> memberEcho(
            @Parameter(description = "Member 객체") MemberDto memberDto
    ) {
        logger.info("Received member {}", memberDto);
        if (memberDto.getName() == null && memberDto.getEmail() == null && memberDto.getOrganization() == null) {
            logger.warn("Received member {} is empty", memberDto);
            return ResponseEntity.status(HttpStatusCode.valueOf(204)).body(memberDto);
        }
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(memberDto);
    }

    @PostMapping("/post-echo")
    @Operation(summary = "Post로 문자열을 받아 그대로 돌려줌")
    public String stringEcho(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "받는 문자열",
                    required = true,
                    content = @Content(mediaType = "text/html")
            ) @RequestBody String string
    ) {
        logger.info("Received string {}", string);
        return string;
    }
}
