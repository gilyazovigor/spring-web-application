package com.example.test_task;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.sources.tables.Organization;
import org.jooq.sources.tables.Worker;
import org.jooq.sources.tables.records.OrganizationRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.test_task.DatasourceConfig;
import lombok.extern.slf4j.Slf4j;
import org.jooq.impl.DSL;

import javax.sql.DataSource;

import static java.lang.Math.toDegrees;
import static org.jooq.impl.DSL.count;
import static org.jooq.sources.tables.Organization.ORGANIZATION;
import static org.jooq.sources.tables.Worker.WORKER;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        //Тут, в Контроллере, должны быть только передача данных в сервис!
        //ниже написанные запросы пока для тестирорвания

        DataSource dataSource = DatasourceConfig.createDataSource();

        //Service.deleteOrganization(dataSource, 10);
        //Service.deleteWorker(dataSource,31);
        //Service.updateWorker(dataSource, 30, "Тест Тестов Тестович", 10, null, "Тестов1 Тест Тестович");
        //Service.updateOrganization(dataSource, 10, "GazpromTest", 1, "GazpromTest2");
        //Service.insertWorker(dataSource, "ВторойТест Тестов Тестович", 10, null);
        //Service.insertOrganization(dataSource, "GazpromSecondTest", 1);
        System.out.println("///////////////////////////////////////////////////////");
        Service.getOrganizations(dataSource);
        System.out.println("///////////////////////////////////////////////////////");
        Service.getWorkers(dataSource);



    }

}


//.selectFrom(Organization.ORGANIZATION)