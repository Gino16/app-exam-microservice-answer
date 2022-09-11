package com.exams.microservices.appexammicroservicceanswer.controllers;

import com.exams.microservices.appexammicroservicceanswer.models.entities.Answer;
import com.exams.microservices.appexammicroservicceanswer.services.AnswerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AnswerController {

  private final AnswerService service;

  @PostMapping
  public ResponseEntity<?> create(@RequestBody Iterable<Answer> answers) {
    return ResponseEntity.status(HttpStatus.CREATED).body(service.saveAll(answers));
  }

  @GetMapping("/student/{studentId}/exam/{examId}")
  public ResponseEntity<?> getAnswersByStudentByExam(@PathVariable Long studentId, @PathVariable Long examId) {
    return ResponseEntity.ok(service.findAnswersByStudentByQuestion(studentId, examId));
  }

  @GetMapping("/student/{studentId}/exams-answered")
  public ResponseEntity<?> getExamsIdsWithAnswersByStudent(@PathVariable Long studentId) {
    return ResponseEntity.ok(service.findExamsIdsWithAnswersByStudent(studentId));
  }
}
