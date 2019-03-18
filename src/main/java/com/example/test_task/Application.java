package com.example.test_task;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.test_task.DatasourceConfig;
import lombok.extern.slf4j.Slf4j;
import org.jooq.impl.DSL;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

}