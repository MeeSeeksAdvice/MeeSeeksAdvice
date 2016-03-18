package com.theironyard.services;

import com.theironyard.entities.Answer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Caroline on 3/18/16.
 */
public interface AnswerRepository extends CrudRepository<Answer, Integer>{
}
