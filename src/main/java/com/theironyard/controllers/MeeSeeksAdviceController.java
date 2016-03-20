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

    @RequestMapping(path = "/question", method = RequestMethod.PUT)
    public void editQuestion(@RequestBody Question question) {
        questions.save(question);

    }

    @RequestMapping(path = "/question/{id}", method = RequestMethod.GET)
    public Question getQuestion(@PathVariable("id") int id) {
//        Question question = questions.findOne(id);
//        question.setAnswer(answer());
        return questions.findOne(id);
    }

    @RequestMapping(path = "/question", method = RequestMethod.GET)
    public List<Question> getQuestions() {
        return (List<Question>) questions.findAll();

    }

    @RequestMapping(path = "/question/{id}", method = RequestMethod.DELETE)
    public void deleteQuestion(@PathVariable("id") int id) {
        questions.delete(id);
    }

    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public void logout(HttpSession session) {
        session.invalidate();
    }

    @RequestMapping(path = "/answer", method = RequestMethod.GET)
    public Answer answer() {
        double random = Math.random() * 101;

        if (random <= 4) {
            return answers.findOne(1);
        } else if (random <= 5 && random >= 8) {
            return answers.findOne(2);
        } else if (random <= 9 && random >= 12) {
            return answers.findOne(3);
        } else if (random <= 13 && random >= 16) {
            return answers.findOne(4);
        } else if (random <= 17 && random >= 20) {
            return answers.findOne(5);
        } else if (random <= 21 && random >= 24) {
            return answers.findOne(6);
        } else if (random <= 25 && random >= 28) {
            return answers.findOne(7);
        } else if (random <= 29 && random >= 32) {
            return answers.findOne(8);
        } else if (random <= 33 && random >= 36) {
            return answers.findOne(9);
        } else if (random <= 37 && random >= 40) {
            return answers.findOne(10);
        } else if (random <= 41 && random >= 44) {
            return answers.findOne(11);
        } else if (random <= 45 && random >= 48) {
            return answers.findOne(12);
        } else if (random <= 49 && random >= 52) {
            return answers.findOne(13);
        } else if (random <= 53 && random >= 56) {
            return answers.findOne(14);
        } else if (random <= 57 && random >= 60) {
            return answers.findOne(15);
        } else if (random <= 61 && random >= 64) {
            return answers.findOne(16);
        } else if (random <= 65 && random >= 68) {
            return answers.findOne(17);
        } else if (random <= 69 && random >= 72) {
            return answers.findOne(18);
        } else if (random <= 73 && random >= 76) {
            return answers.findOne(19);
        } else if (random <= 77 && random >= 80) {
            return answers.findOne(20);
        } else if (random <= 81 && random >= 84) {
            return answers.findOne(21);
        } else if (random <= 85 && random >= 88) {
            return answers.findOne(22);
        } else if (random <= 89 && random >= 92) {
            return answers.findOne(23);
        } else if (random <= 93 && random >= 96) {
            return answers.findOne(24);
        } else {
            return answers.findOne(25);
        }
    }
}