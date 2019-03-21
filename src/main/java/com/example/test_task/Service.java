package com.example.test_task;

import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.sources.tables.Organization;
import org.jooq.sources.tables.records.OrganizationRecord;
import org.jooq.sources.tables.Worker;
import org.jooq.sources.tables.records.WorkerRecord;
import org.springframework.ui.Model;

import javax.sql.DataSource;


public class Service {


    //Тут должна быть проверка данных на различные ограничение
    //Если данные некорректные, то передача ошибки обратно в Контроллер
    //Если данные коректные, то передача данных в репозиторий с API для выполнения

    /*
    public String getCompanyID (String name, Model model) {
        OrganizationRecord organizationRecord =
                DSL.using(SQLDialect.POSTGRES)
                        .selectFrom(Organization.ORGANIZATION)
                        .where(Organization.ORGANIZATION.ORGANIZATIONNAME.eq(name))
                        .fetchAny();
        model.addAttribute("name", organizationRecord);
        return "db_html";
    }
    */

}
