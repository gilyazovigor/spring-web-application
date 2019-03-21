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
      //  OrganizationRecord organizationRecord =
               Result<OrganizationRecord> organizationRecord =
                DSL.using(dataSource, SQLDialect.POSTGRES)
                        .selectFrom(ORGANIZATION)
                        .where(ORGANIZATION.ORGANIZATIONID.between(4,8))
                        .fetch();
     //                   .fetchAny();
        System.out.println(organizationRecord);

        System.out.println("//////////////////////////");

        Result<?> orgList =
                DSL.using(dataSource, SQLDialect.POSTGRES)
                      .select(ORGANIZATION.ORGANIZATIONID,
                              ORGANIZATION.ORGANIZATIONNAME,
                              ORGANIZATION.ORGANIZATION_ORGANIZATIONID
                                                            //СЮДА ЕЩЕ COUNT РАБОТНИКОВ!!!!!!!!!!!!!!!!!!
                      )
                        .from(ORGANIZATION)
                        .join(WORKER)
                        .on(ORGANIZATION.ORGANIZATIONID.eq(WORKER.WORKER_ORGANIZATIONID))
                        .where()
                        .fetch();
        System.out.println(orgList);
    }

}


//.selectFrom(Organization.ORGANIZATION)