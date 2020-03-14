package com.spring.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spring.service.CustomerService;
import com.spring.vo.CustomerVO;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
//	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService service;
	
	@GetMapping
	public List<CustomerVO> list() {
		return service.list();
	}
	@PostMapping()
	public void add(@RequestParam("image") MultipartFile image,HttpServletRequest req)throws Exception {
		
		CustomerVO customerVO = new CustomerVO();
		
		customerVO.setName(req.getParameter("name"));
		customerVO.setBirthday(req.getParameter("birthday"));
		customerVO.setGender(req.getParameter("gender"));
		customerVO.setJob(req.getParameter("job"));
		
		String fileName = image.getOriginalFilename();
		String fileNameExtension = FilenameUtils.getExtension(fileName).toLowerCase();
		File destinationFile;
		String destinationFileName;
		String fileUrl = "D:/공부//react//react-app//public//images/";
		
		 do { 
             destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "." + fileNameExtension; 
             destinationFile = new File(fileUrl+ destinationFileName); 
         } while (destinationFile.exists()); 
         
         destinationFile.getParentFile().mkdirs();
         image.transferTo(destinationFile); 

         customerVO.setImage("/images/"+ destinationFileName);


         service.add(customerVO);
		
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		service.delete(id);
	}
}
