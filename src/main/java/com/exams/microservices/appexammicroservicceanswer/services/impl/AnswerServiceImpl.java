package com.exams.microservices.appexammicroservicceanswer.services.impl;

import com.exams.microservices.appexamlibcommonexams.models.entities.Exam;
import com.exams.microservices.appexamlibcommonexams.models.entities.Question;
import com.exams.microservices.appexammicroservicceanswer.clients.ExamFeignClient;
import com.exams.microservices.appexammicroservicceanswer.models.entities.Answer;
import com.exams.microservices.appexammicroservicceanswer.models.repositories.AnswerRepository;
import com.exams.microservices.appexammicroservicceanswer.services.AnswerService;
import java.util.Collections;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AnswerServiceImpl implements AnswerService {

  private final AnswerRepository repository;
  private final ExamFeignClient examFeignClient;

  @Override
  public Iterable<Answer> saveAll(Iterable<Answer> answers) {
    return repository.saveAll(answers);
  }

  @Override
  public Iterable<Answer> findAnswersByStudentByQuestion(Long studentId, Long examId) {
    Exam exam = examFeignClient.findById(examId);
    List<Question> questions = exam.getQuestions();
    List<Long> questionIds = questions.stream().map(Question::getId).toList();
    List<Answer> answers = (List<Answer>) repository.findAnswerByStudentAndQuestion(studentId,
        questionIds);
    answers = answers.stream()
        .peek(a -> questions.stream().filter(q -> q.getId().equals(a.getQuestionId())).findFirst()
            .ifPresent(a::setQuestion)).toList();
    return answers;
  }

  @Override
  public Iterable<Long> findExamsIdsWithAnswersByStudent(Long studentId) {
    List<Answer> answers = (List<Answer>) repository.findByStudentId(studentId);
    List<Long> examIds;
    if (answers.isEmpty()) {
      return List.of();
    }
    List<Long> questionIds = answers.stream().map(Answer::getQuestionId).toList();
    examIds = examFeignClient.findExamIdsWithAnswersByQuestionIds(questionIds);
    return examIds;
  }

  @Override
  public Iterable<Answer> findByStudentId(Long studentId) {
    return repository.findByStudentId(studentId);
  }
}