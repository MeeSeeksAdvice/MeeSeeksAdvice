package com.theironyard.services;

import com.theironyard.entities.Question;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ericweidman on 3/17/16.
 */
public interface QuestionRepository extends CrudRepository<Question, Integer> {
}
