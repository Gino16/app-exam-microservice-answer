package com.exams.microservices.appexammicroservicceanswer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class AppExamMicroserviceAnswerApplication {

  public static void main(String[] args) {
    SpringApplication.run(AppExamMicroserviceAnswerApplication.class, args);
  }

}
