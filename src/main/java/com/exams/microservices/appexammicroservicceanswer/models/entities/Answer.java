package com.exams.microservices.appexammicroservicceanswer.models.entities;

import com.exams.microservices.appexamlibcommonexams.models.entities.Question;
import com.exams.microservices.libcommonstudents.models.entities.Student;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "answers")
public class Answer {

  @Id
  private String id;

  private String text;

  @Transient
  private Student student;

  private Long studentId;

  @Transient
  private Question question;

  private Long questionId;
}
