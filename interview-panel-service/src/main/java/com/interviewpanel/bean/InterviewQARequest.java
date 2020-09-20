package com.interviewpanel.bean;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


@Document(collection  = "interviewqa")
@Data
public class InterviewQARequest {
	
    private String qId;
	private String employerName;
	private String technology;
	private String questionAsked;
	private String givenAnswer;
	private String interviewDate;
	//private List<QABlock> qaBlock;

}
