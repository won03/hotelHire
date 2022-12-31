package com.wlee.hoteljob.controller;

import com.wlee.hoteljob.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/temp")
public class ApiTempController {
    @PostMapping("")
    public User user(@RequestBody User user) {
        log.info("temp: {}", user);
        return user;
    }
}
