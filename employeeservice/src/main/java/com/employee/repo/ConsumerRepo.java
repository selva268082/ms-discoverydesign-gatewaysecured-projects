package com.employee.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.entities.Consumer;

public interface ConsumerRepo extends JpaRepository<Consumer, Long> {
	
	List<Consumer> findByConsumerId(int consumerId);
	List<Consumer> findByConsumerName(String consumerName);
	
	 
	Consumer getByConsumerName(String consumerName);

}

