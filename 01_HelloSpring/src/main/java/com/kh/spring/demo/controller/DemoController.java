package com.kh.spring.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.kh.spring.demo.model.service.DemoService;

@Controller
public class DemoController {

	// DI (의존주입)
	// 필드로 생성
	@Autowired
	DemoService demoService;
}
