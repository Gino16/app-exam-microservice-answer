package com.exams.microservices.appexammicroservicceanswer.models.repositories;

import com.exams.microservices.appexammicroservicceanswer.models.entities.Answer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface AnswerRepository extends MongoRepository<Answer, String> {

  @Query("{'studentId': ?0, 'questionId': {$in: ?1}}")
  public Iterable<Answer> findAnswerByStudentAndQuestion(Long studentId, Iterable<Long> questionId);

  @Query("{'studentId': ?0}")
  public Iterable<Answer> findByStudentId(Long studentId);
}
