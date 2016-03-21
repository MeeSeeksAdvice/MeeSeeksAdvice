package com.theironyard.controllers;

import com.theironyard.entities.Answer;
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
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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

    public static Random random = new Random();

    Server dbui = null;

    @PostConstruct
    public void init() throws SQLException, FileNotFoundException {
        dbui = Server.createWebServer().start();

        if (answers.count() == 0) {
            File f = new File("answers.csv");
            Scanner scanner = new Scanner(f);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                Answer answer = new Answer(line);
                answers.save(answer);
            }
        }
    }

    @PreDestroy
    public void destory() {
        dbui.stop();
    }

    @RequestMapping(path = "/user", method = RequestMethod.POST)
    public User addUser(@RequestBody User user, HttpSession session) {
        User userExsist = users.findByUserName(user.getUserName());
        if (userExsist == null) {
            userExsist = user;
            users.save(user);
        }
        session.setAttribute("userName", userExsist.getUserName());
        return userExsist;
    }

    @RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable("id") int id, HttpSession session) {
        String userName = (String) session.getAttribute("userName");
        return users.findByUserName(userName);
    }

    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public List<User> getUsers() {
        return (List<User>) users.findAll();
    }

    @RequestMapping(path = "/question", method = RequestMethod.POST)
    public Question addQuestion(@RequestBody Question question, HttpSession session) {
        String userName = (String) session.getAttribute("userName");
        User user = users.findByUserName(userName);
        question.setUser(user);
        questions.save(question);
        return question;
    }

    @RequestMapping(path = "/user/question/{id}", method = RequestMethod.GET)
    public List<Question> getUsersQuestions(@PathVariable("id") int id, HttpSession session) {
        String userName = (String) session.getAttribute("userName");
        User user = users.findByUserName(userName);
        List<Question> localQuestions = questions.findByUser(user);

        for (Question question : localQuestions) {
            question.setAnswer(getRandomAnswer());
        }
        return localQuestions;
    }

    @RequestMapping(path = "/question/{id}", method = RequestMethod.PUT)
    public Question editQuestion(@PathVariable("id") int id, @RequestBody Question question) {
        Question persistedQuestion = questions.findOne(id);
        persistedQuestion = question;
        questions.save(question);
        return question;
    }

    @RequestMapping(path = "/question/{id}", method = RequestMethod.GET)
    public Question getQuestion(@PathVariable("id") int id) {
        Question question = questions.findOne(id);
        question.setAnswer(getRandomAnswer());
        return questions.findOne(id);
    }

    @RequestMapping(path = "/user/question/{id}", method = RequestMethod.PUT)
    public Question editUserQuestion(@PathVariable("id") int id, @RequestBody Question question) {
        Question persistedQuestion = questions.findOne(id);
        persistedQuestion = question;
        questions.save(question);
        return question;
    }

    @RequestMapping(path = "/question", method = RequestMethod.GET)
    public List<Question> getQuestions() {
        List<Question> localQuestions = (List<Question>) questions.findAll();
        for (Question question : localQuestions) {
            question.setAnswer(getRandomAnswer());
        }
        return localQuestions;
    }

    @RequestMapping(path = "/question/{id}", method = RequestMethod.DELETE)
    public void deleteQuestion(@PathVariable("id") int id) {
        questions.delete(id);
    }

    @RequestMapping(path = "/user/question", method = RequestMethod.DELETE)
    public User deleteUserQuestion(@PathVariable("id") int id, HttpSession session) {
        String userName = (String) session.getAttribute("userName");
        User user = users.findByUserName(userName);
        questions.delete(user.getId());
        return null;
    }

    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public void logout(HttpSession session) {
        session.invalidate();
    }

    public Answer getRandomAnswer() {
        //http://www.javapractices.com/topic/TopicAction.do?Id=62
        //get the range, casting to long to avoid overflow problems
        long range = (long) 25 - (long) 1 + 1;
        // compute a fraction of the range, 0 <= frac < range
        long fraction = (long) (range * random.nextDouble());
        int randomNumber = (int) (fraction + 1);
        if (randomNumber > 25) {
            randomNumber = 25;
        }
        return answers.findOne(randomNumber);
    }
}