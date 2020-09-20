package com.interviewpanel.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.interviewpanel.bean.InterviewQARequest;

public interface InterviewRepository extends MongoRepository<InterviewQARequest, String>{

}
