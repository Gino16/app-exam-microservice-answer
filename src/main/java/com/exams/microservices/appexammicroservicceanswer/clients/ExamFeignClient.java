package com.exams.microservices.appexammicroservicceanswer.clients;

import com.exams.microservices.appexamlibcommonexams.models.entities.Exam;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "exam-service")
public interface ExamFeignClient {

  @GetMapping({"/{id}"})
  public Exam findById(@PathVariable("id") Long id);

  @GetMapping("/answered-by-questions")
  public List<Long> findExamIdsWithAnswersByQuestionIds(@RequestParam List<Long> questionIds);
}
