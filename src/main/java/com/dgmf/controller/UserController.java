package com.dgmf.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(
        value = "/api/v1/users",
        consumes = MediaType.APPLICATION_JSON_VALUE
)
public class UserController {
    @PostMapping("/registration")
    public void register() {
        log.info("Registration");
    }
}
