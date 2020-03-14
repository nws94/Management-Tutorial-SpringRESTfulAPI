package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mapper.CustomerMapper;
import com.spring.vo.CustomerVO;

@Service
public class CustomerService {
	@Autowired
	private CustomerMapper mapper;
	
	public List<CustomerVO> list() {
		return mapper.list();
	}
	
	public void add(CustomerVO customerVO) {
		mapper.add(customerVO);
	}
	
	public void delete(int id) {
		mapper.delete(id);
	}
}
