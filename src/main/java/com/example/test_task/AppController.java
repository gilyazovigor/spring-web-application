package com.example.test_task;

import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.sources.tables.Organization;
import org.jooq.sources.tables.Worker;
import org.jooq.sources.tables.records.OrganizationRecord;
import org.jooq.sources.tables.records.WorkerRecord;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;

@Controller
public class AppController {

    @GetMapping("/greeting")
    public String greeting (@RequestParam(name="name", required=false, defaultValue="proIT") String name, Model model)
    {
        model.addAttribute("name", name);
        return "greeting";
    }


    @GetMapping("/")
    public  String run_html (@RequestParam(name="name", required = false, defaultValue = "Gazpromneft") String name, Model model)
    {
        //String res_org = "";

        DataSource dataSource = DatasourceConfig.createDataSource();
        OrganizationRecord organizationRecord =
        DSL.using(dataSource, SQLDialect.POSTGRES)
                .selectFrom(Organization.ORGANIZATION)
                .where(Organization.ORGANIZATION.ORGANIZATIONNAME.eq(name))
                .fetchAny();

        model.addAttribute("name", organizationRecord);
        return "db_html";
    }
}