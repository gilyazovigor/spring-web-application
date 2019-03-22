package com.example.test_task;
import ServiceDir.Service;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.sql.DataSource;
import static org.jooq.impl.DSL.count;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        //Тут, в Контроллере, должны быть только передача данных в сервис!
        //ниже написанные запросы пока для тестирорвания

        DataSource dataSource = DatasourceConfig.createDataSource();

        //Service.deleteOrganization(dataSource, 10);
        //Service.deleteWorker(dataSource,31);
        //Service.insertWorker(dataSource, "ТретийТест Тестов Тестович", 11, null);

        Service.updateWorker(dataSource, 30, "Тест Тестов Тестович",
                10, null,
                "Тестов11 Тест Тестович",
                10,32);

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