package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entities.Consumer;
import com.employee.repo.ConsumerRepo;

@Service
public class ConsumerService {
	@Autowired
	ConsumerRepo consumerRepo;
	public void saveConsumer(Consumer consumer) {
		consumerRepo.save(consumer);
	}
	
	
	public List<Consumer> findConsumerId(int consumerId) {
		return consumerRepo.findByConsumerId(consumerId);
	}
	
	
	public List<Consumer> findConsumerName(String consumerName) {
		return consumerRepo.findByConsumerName(consumerName);
	}
	
	public Consumer getConsumerName(String consumerName) {
		return consumerRepo.getByConsumerName(consumerName);
	}
}
