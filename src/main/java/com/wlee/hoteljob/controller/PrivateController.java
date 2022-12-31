package com.wlee.hoteljob.controller;

import com.wlee.hoteljob.annotation.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/private")
@Auth
public class PrivateController {
    @GetMapping("/hello")
    public String Hello(){
        log.info("here : private");
        return "Private Hello";
    }
}
