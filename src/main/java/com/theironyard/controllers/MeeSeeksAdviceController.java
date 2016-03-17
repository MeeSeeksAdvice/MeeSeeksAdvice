package com.theironyard.controllers;

import com.theironyard.services.QuestionRepository;
import com.theironyard.services.UserRepository;
import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.SQLException;

/**
 * Created by ericweidman on 3/17/16.
 */
@RestController
public class MeeSeeksAdviceController {
    @Autowired
    UserRepository users;
    @Autowired
    QuestionRepository questions;

Server dbui = null;

    @PostConstruct
    public void init() throws SQLException {
        dbui = Server.createWebServer().start();
    }

    @PreDestroy
    public void destory(){
        dbui.stop();
    }
}
