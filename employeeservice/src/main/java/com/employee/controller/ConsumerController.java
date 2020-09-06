package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entities.Consumer;
import com.employee.service.ConsumerService;

@RestController
@RequestMapping(path = "/consumer")
public class ConsumerController {
	//http://ucswendev1:8080/register/1010101
		
	//http://ucswendev1:8081/register/1010101
	@Autowired
	ConsumerService consumerService;
	
	@PostMapping(path = "/create")
	public String createConsumer(@RequestBody Consumer consumer)
	{
		consumerService.saveConsumer(consumer);
		return "Created";
	}
	
	@GetMapping(path = "/fetch/id/{consumerId}")
	public List<Consumer> getConsumerById(@PathVariable Integer consumerId)
	{
		return consumerService.findConsumerId(consumerId);
	}
	
	
	@GetMapping(path = "/fetch/name/{consumerName}")
	public List<Consumer> getConsumerByName(@PathVariable String consumerName)
	{
		return consumerService.findConsumerName(consumerName);
	}
	

	@GetMapping(path = "/fetch/name/jpql/{consumerName}")
	public Consumer getConsumerByNameJPQL(@PathVariable String consumerName)
	{
		return consumerService.getConsumerName(consumerName);
	}
}
