package com.wlee.hoteljob.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/*
* 모든 사용자가 사용가능한 api
* */
@Slf4j
@RestController
@RequestMapping("/api/public")
public class PublicController {
    @GetMapping("/hello")
    public String hello() {
        log.info("here : public");
        return "public Hello";
    }
}
