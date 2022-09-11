package com.exams.microservices.appexammicroservicceanswer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.exams.microservices.appexammicroservicceanswer.models.entities",
    "com.exams.microservices.appexamlibcommonexams.models.entities",
    "com.exams.microservices.libcommonstudents.models.entities"})
public class AppExamMicroservicceAnswerApplication {

  public static void main(String[] args) {
    SpringApplication.run(AppExamMicroservicceAnswerApplication.class, args);
  }

}
