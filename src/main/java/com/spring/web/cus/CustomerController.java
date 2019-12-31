package com.spring.web.cus;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.web.util.Printer;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class CustomerController {

	@Autowired private CustomerRepository customerRepository;
	@Autowired private Customer customer;
	@Autowired private Printer printer;
	
	@RequestMapping("/join")
	public void join (@RequestBody Customer param){
		printer.accept("join 진입");

		customer.setCno("1");
		customer.setCemail(param.getCemail());
		customer.setCpwd(param.getCpwd());
		customer.setCname(param.getCname());
		customer.setCphone(param.getCphone());
		
		printer.accept(customer.toString());
		
		customerRepository.save(customer);
	}
}