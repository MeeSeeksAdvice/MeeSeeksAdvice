package com.theironyard.entities;


import javax.persistence.*;

/**
 * Created by ericweidman on 3/17/16.
 */
@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String question;

    @ManyToOne
    User user;

    @ManyToOne
    Answer answer;

    public Question() {
    }

    public Question(Answer answer, User user, String question) {
        this.answer = answer;
        this.user = user;
        this.question = question;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
