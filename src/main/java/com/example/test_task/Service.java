package com.example.test_task;

import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.sources.tables.Organization;
import org.jooq.sources.tables.records.OrganizationRecord;
import org.jooq.sources.tables.Worker;
import org.jooq.sources.tables.records.WorkerRecord;
import org.springframework.ui.Model;

import javax.sql.DataSource;

import static org.jooq.sources.tables.Organization.ORGANIZATION;


public class Service {


    //Тут должна быть проверка данных на различные ограничение
    //Если данные некорректные, то передача ошибки обратно в Контроллер
    //Если данные коректные, то передача данных в репозиторий с API для выполнения

    public static void getOrganizations(DataSource dataSource)
    {

        //  OrganizationRecord organizationRecord =
        Result<OrganizationRecord> organizationRecord =
                DSL.using(dataSource, SQLDialect.POSTGRES)
                        .selectFrom(ORGANIZATION)
                        .where()
                        .fetch();
        //                   .fetchAny();
        System.out.println(organizationRecord);

    }

    public static void getWorkers(DataSource dataSource)
    {
        Result<WorkerRecord> workerRecord =
                DSL.using(dataSource, SQLDialect.POSTGRES)
                        .selectFrom(Worker.WORKER)
                        .where()
                        .fetch();
            System.out.println(workerRecord);
    }

    public static void insertOrganization(DataSource dataSource, String orgName,Integer orgHeadId)
    {
        DSL.using(dataSource, SQLDialect.POSTGRES)
                .insertInto(ORGANIZATION)
                .set(ORGANIZATION.ORGANIZATIONNAME, orgName)
                .set(ORGANIZATION.ORGANIZATION_ORGANIZATIONID, orgHeadId)
                .execute();
    }

    public static void insertWorker(DataSource dataSource, String workerName,
                                    Integer workerOrgId, Integer workerWorkerId)
    {

        DSL.using(dataSource, SQLDialect.POSTGRES)
                .insertInto(Worker.WORKER)
                .set(Worker.WORKER.WORKERNAME, workerName)
                .set(Worker.WORKER.WORKER_ORGANIZATIONID, workerOrgId)
                .set(Worker.WORKER.WORKER_WORKERID, workerWorkerId)
                .execute();
    }

    public static  void updateOrganization(DataSource dataSource, Integer orgId,
                                           String orgName,Integer orgHeadId, String newOrgName)
    {
        DSL.using(dataSource, SQLDialect.POSTGRES)
                .insertInto(ORGANIZATION)
                .set(ORGANIZATION.ORGANIZATIONID, orgId)
                .set(ORGANIZATION.ORGANIZATIONNAME, orgName)
                .set(ORGANIZATION.ORGANIZATION_ORGANIZATIONID, orgHeadId)
                .onConflict()
                .doUpdate()
                .set(ORGANIZATION.ORGANIZATIONNAME, newOrgName)
                .execute();
    }

    public static  void updateWorker(DataSource dataSource, Integer workerID, String workerName,
                                     Integer workerOrgId, Integer workerWorkerId, String newWorkerName )
    {
        DSL.using(dataSource, SQLDialect.POSTGRES)
                .insertInto(Worker.WORKER)
                .set(Worker.WORKER.WORKERID, workerID)
                .set(Worker.WORKER.WORKERNAME, workerName)
                .set(Worker.WORKER.WORKER_ORGANIZATIONID, workerOrgId)
                .set(Worker.WORKER.WORKER_WORKERID, workerWorkerId)
                .onConflict()
                .doUpdate()
                .set(Worker.WORKER.WORKERNAME, newWorkerName)
                .execute();
    }

    public static void deleteOrganization(DataSource dataSource, Integer orgId)
    {
        DSL.using(dataSource, SQLDialect.POSTGRES)
                .delete(ORGANIZATION)
                .where(ORGANIZATION.ORGANIZATIONID.eq(orgId))
                .execute();
    }

    public static void deleteWorker(DataSource dataSource, Integer workerId)
    {
        DSL.using(dataSource, SQLDialect.POSTGRES)
                .delete(Worker.WORKER)
                .where(Worker.WORKER.WORKERID.eq(workerId))
                .execute();
    }
    //

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

    /*
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
        */

}
