package com.interviewpanel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interviewpanel.bean.InterviewQARequest;
import com.interviewpanel.repo.InterviewRepository;
import com.interviewpanel.service.InterviewpanelService;

@Service
public class InterviewpanelServiceImpl implements InterviewpanelService{

	@Autowired
	InterviewRepository interviewRepository;

	@Override
	public InterviewQARequest addInterviewQA(InterviewQARequest interviewQARequest) {
		// TODO Auto-generated method stub
		return interviewRepository.save(interviewQARequest);
	}
	
	@Override
	public List<InterviewQARequest> retrieveAllQAs() {
		// TODO Auto-generated method stub
		return interviewRepository.findAll();
	}

	
	
	

}
