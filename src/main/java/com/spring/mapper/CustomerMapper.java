package com.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.spring.vo.CustomerVO;

@Repository
@Mapper
public interface CustomerMapper {
	public List<CustomerVO> list();
	public void add(CustomerVO customerVO);
	public void delete(int id);
}
