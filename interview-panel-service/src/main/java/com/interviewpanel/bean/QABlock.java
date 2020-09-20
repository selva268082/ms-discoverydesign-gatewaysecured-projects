package com.interviewpanel.bean;

import java.util.List;

import lombok.Data;

@Data
public class QABlock {
	
	private String qId;
	private String askedQuestion;
	private List<Answer> listAnswers;

}
