package com.theironyard.controllers;

import com.theironyard.entities.Question;
import com.theironyard.entities.User;
import com.theironyard.services.AnswerRepository;
import com.theironyard.services.QuestionRepository;
import com.theironyard.services.UserRepository;
import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ericweidman on 3/17/16.
 */
@RestController
public class MeeSeeksAdviceController {
    @Autowired
    UserRepository users;
    @Autowired
    QuestionRepository questions;
    @Autowired
    AnswerRepository answers;

Server dbui = null;

    @PostConstruct
    public void init() throws SQLException {
        dbui = Server.createWebServer().start();
    }

    @PreDestroy
    public void destory(){
        dbui.stop();
    }

    @RequestMapping(path = "/user", method = RequestMethod.POST)
    public User addUser(@RequestBody User user, HttpSession session){
        User userExsist = users.findByUserName(user.getUserName());
        if(userExsist == null){
            userExsist = user;
            users.save(user);
        }
        session.setAttribute("userName", userExsist.getUserName());
        return userExsist;

    }
    @RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable("id") int id, HttpSession session){
        String userName = (String) session.getAttribute("userName");
        return users.findByUserName(userName);
    }

    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public List<User> getUsers() {
        return (List<User>) users.findAll();
    }

    @RequestMapping(path = "/question", method = RequestMethod.POST)
    public Question addQuestion(@RequestBody Question question, HttpSession session){
        String userName = (String) session.getAttribute("userName");
        User user = users.findByUserName(userName);
        question.setUser(user);
        questions.save(question);
        return question;

    }
    @RequestMapping(path = "/question", method = RequestMethod.PUT)
    public void editQuestion(@RequestBody Question question) {
        questions.save(question);
    }
    @RequestMapping(path = "/question/{id}", method = RequestMethod.GET)
    public Question getQuestion(@PathVariable("id") int id) {
        return questions.findOne(id);
    }

    @RequestMapping(path = "/question", method = RequestMethod.GET)
    public List<Question> getQuestions() {
        return (List<Question>) questions.findAll();
    }

    @RequestMapping(path = "/question/{id}", method = RequestMethod.DELETE)
    public void  deleteQuestion(@PathVariable("id") int id) {
        questions.delete(id);
    }

    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public void logout(HttpSession session) {
        session.invalidate();
    }
}
