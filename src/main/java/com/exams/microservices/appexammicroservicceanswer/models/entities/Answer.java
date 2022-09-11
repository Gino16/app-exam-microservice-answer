package com.exams.microservices.appexammicroservicceanswer.models.entities;

import com.exams.microservices.appexamlibcommonexams.models.entities.Question;
import com.exams.microservices.libcommonstudents.models.entities.Student;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "answers")
public class Answer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String text;

  @ManyToOne(fetch = FetchType.LAZY)
  private Student student;

  @OneToOne(fetch = FetchType.LAZY)
  private Question question;;
}
