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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;

@Controller
public class AppController {

    public DataSource dataSource = DatasourceConfig.createDataSource();

    @GetMapping("/greeting")
    public String greeting (@RequestParam(name="name", required=false, defaultValue="proIT") String name, Model model)
    {
        model.addAttribute("name", name);
        return "greeting";
    }


    @GetMapping("/getOrganizations")
    public  String run_html (@RequestParam(name="name", required = false, defaultValue = "Gazpromneft") String name, Model model)
    {
        //String res_org = "";

        return "db_html";
    }

    /*
    @PostMapping("/createWorker")
    public String nameSmth ()
    {

    }
    */

}