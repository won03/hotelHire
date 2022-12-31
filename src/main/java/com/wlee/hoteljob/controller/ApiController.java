package com.wlee.hoteljob.controller;

import com.wlee.hoteljob.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j // System.out.println();이 아닌 log를 남길 수 있게 도와준다
@RestController
@RequestMapping("/api/user")
public class ApiController {

    @PostMapping("")
    public User user(@RequestBody User user) {
        log.info("User : {}", user);
        return user;
    }
}
