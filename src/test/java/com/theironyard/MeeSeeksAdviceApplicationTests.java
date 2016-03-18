package com.theironyard;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.theironyard.entities.Question;
import com.theironyard.services.QuestionRepository;
import com.theironyard.services.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = MeeSeeksAdviceApplication.class)
//@WebAppConfiguration
//public class MeeSeeksAdviceApplicationTests {
//
//
//    @Autowired
//    UserRepository users;
//
//    @Autowired
//    QuestionRepository questions;
//
//    @Autowired
//    WebApplicationContext wap;
//
//    MockMvc mockMvc;
//
//    @Before
//    public void before() {
//        mockMvc = MockMvcBuilders.webAppContextSetup(wap).build();
//    }
//
////    @Test
////    public void addQuestion() throws Exception {
////        Question question = new Question();
////        question.setQuestion("Wat?");
////
////        ObjectMapper mapper = new ObjectMapper();
////        String json = mapper.writeValueAsString(question);
////
////        mockMvc.perform(
////                MockMvcRequestBuilders.post("/question")
////                        .content(json)
////                        .contentType("application/json")
////
////        );
////        Assert.assertTrue(questions.count() == 1);
////    }
////
////    @Test
////    public void editQuestion() throws Exception {
////        addQuestion();
////        Question question = new Question();
////        question.setQuestion("This is a new question?");
////
////        ObjectMapper mapper = new ObjectMapper();
////        String json = mapper.writeValueAsString(question);
////
////        mockMvc.perform(
////                MockMvcRequestBuilders.put("/question/1")
////                .content(json)
////                .contentType("application/json")
////        );
////        Assert.assertTrue(questions.findOne(1).getQuestion().equals("This is a new question?"));
////  }
//
//    @Test
//    public void deleteUser() throws Exception {
//        mockMvc.perform(
//                MockMvcRequestBuilders.delete("/question/1")
//        );
//        Assert.assertTrue(questions.count() == 0);
//    }
//}
