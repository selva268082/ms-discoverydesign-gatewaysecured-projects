//package com.employee.controller;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.Before;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import com.employee.entities.Consumer;
//import com.employee.util.GetPathUtil;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import junit.framework.Assert;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//class ConsumerControllerTest {
//
//
//	private MockMvc mockMvc;
//	
//	@Autowired
//	private WebApplicationContext context;
//	
//	@Before
//	private void setUp() {
//		mockMvc=MockMvcBuilders.webAppContextSetup(context).build();
//	}
//	
//	@Test
//	final void testCreateConsumer() throws Exception {
//	mockMvc=MockMvcBuilders.webAppContextSetup(context).build();
//    ObjectMapper objectMapper=new ObjectMapper();
//    String inputFilePath="/Consumer/Consumer.jason";
//    Consumer consumerObj=objectMapper.readValue(GetPathUtil.getUrl(inputFilePath),Consumer.class);
//    
//    String jsonRequest=objectMapper.writeValueAsString(consumerObj);
//    
//    MvcResult mvcResult=mockMvc.perform(post("/consumer/create").content(jsonRequest)
//    		                   .content(MediaType.APPLICATION_JSON_VALUE)).andReturn();
//    
//    String responseString=mvcResult.getResponse().getContentAsString();
//    
//    Assert.assertTrue(responseString.equalsIgnoreCase("Created"));
//	
// 
//	}
//
//	@Test
//	final void testGetConsumerById() {
//		 
//	}
//
//}
