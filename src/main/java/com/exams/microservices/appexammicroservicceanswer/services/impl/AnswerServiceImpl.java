package com.exams.microservices.appexammicroservicceanswer.services.impl;

import com.exams.microservices.appexammicroservicceanswer.models.entities.Answer;
import com.exams.microservices.appexammicroservicceanswer.models.repositories.AnswerRepository;
import com.exams.microservices.appexammicroservicceanswer.services.AnswerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class AnswerServiceImpl implements AnswerService {

  private final AnswerRepository repository;

  @Override
  @Transactional
  public Iterable<Answer> saveAll(Iterable<Answer> answers) {
    return repository.saveAll(answers);
  }

  @Override
  @Transactional(readOnly = true)
  public Iterable<Answer> findAnswersByStudentByQuestion(Long studentId, Long examId) {
    return repository.findAnswersByStudentByQuestion(studentId, examId);
  }

  @Override
  @Transactional(readOnly = true)
  public Iterable<Long> findExamsIdsWithAnswersByStudent(Long studentId) {
    return repository.findExamsIdsWithAnswersByStudent(studentId);
  }
}