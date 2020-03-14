package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mapper.TestMapper;
import com.spring.vo.TestVO;

@Service
public class TestService {
	@Autowired
	public TestMapper mapper;
	
	public List<TestVO> selectTest() throws Exception {
		return mapper.selectTest();
	}
}
