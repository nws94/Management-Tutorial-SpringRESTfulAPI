package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.service.TestService;
import com.spring.vo.TestVO;

@RestController
public class TestController {
	
	@Autowired
	private TestService service;
	
	@RequestMapping("/test")
	public List<TestVO> selectTest() throws Exception {
		return service.selectTest();
	}
	
}
