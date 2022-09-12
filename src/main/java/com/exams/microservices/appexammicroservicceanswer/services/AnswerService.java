package com.exams.microservices.appexammicroservicceanswer.services;

import com.exams.microservices.appexammicroservicceanswer.models.entities.Answer;

public interface AnswerService {
  public Iterable<Answer> saveAll(Iterable<Answer> answers);
  public Iterable<Answer> findAnswersByStudentByQuestion(Long studentId, Long examId);
  public Iterable<Long> findExamsIdsWithAnswersByStudent(Long studentId);

  public Iterable<Answer> findByStudentId(Long studentId);
}
