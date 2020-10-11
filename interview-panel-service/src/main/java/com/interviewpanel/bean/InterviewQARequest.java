package com.interviewpanel.bean;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


@Document(collection  = "interviewqa")
@Data
public class InterviewQARequest {
	
    private String questionPostedBy;
	private String employerName;
	private List<QuestionAnswers> questionAnswers;
	private String interviewDate;
 
}
