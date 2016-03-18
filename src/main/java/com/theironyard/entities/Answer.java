package com.theironyard.entities;

import javax.persistence.*;

/**
 * Created by Caroline on 3/18/16.
 */
@Entity
@Table(name = "answers")
public class Answer {
    @Id
    @GeneratedValue
    int id;

    @Column
    String answer;

    public Answer() {
    }

    public Answer(String answer) {
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
