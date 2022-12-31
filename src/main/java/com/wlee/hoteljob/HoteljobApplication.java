package com.wlee.hoteljob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@SpringBootApplication
//@WebFilter를 사용하기 위한 어노테이션
@ServletComponentScan
public class HoteljobApplication {

	public static void main(String[] args) {
		SpringApplication.run(HoteljobApplication.class, args);
	}

}
