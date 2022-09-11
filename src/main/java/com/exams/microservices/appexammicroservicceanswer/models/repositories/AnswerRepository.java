package com.exams.microservices.appexammicroservicceanswer.models.repositories;

import com.exams.microservices.appexammicroservicceanswer.models.entities.Answer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends CrudRepository<Answer, Long> {

  @Query("SELECT a FROM Answer a JOIN FETCH a.student s JOIN FETCH a.question q JOIN FETCH q.exam e WHERE s.id = ?1 AND e.id = ?2")
  public Iterable<Answer> findAnswersByStudentByQuestion(Long studentId, Long examId);

  @Query("SELECT e.id FROM Answer a JOIN a.student s JOIN a.question q JOIN q.exam e WHERE s.id = ?1 GROUP BY e.id")
  public Iterable<Long> findExamsIdsWithAnswersByStudent(Long studentId);
}
