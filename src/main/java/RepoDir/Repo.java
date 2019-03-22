package RepoDir;

import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.sources.tables.Organization;
import org.jooq.sources.tables.Worker;
import org.jooq.sources.tables.records.OrganizationRecord;
import org.jooq.sources.tables.records.WorkerRecord;
import javax.sql.DataSource;
import static org.jooq.sources.tables.Organization.ORGANIZATION;


public class Repo {


    public static void getOrganizationsAPI(DataSource dataSource)
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

    public static void getWorkersAPI(DataSource dataSource)
    {
        Result<WorkerRecord> workerRecord =
                DSL.using(dataSource, SQLDialect.POSTGRES)
                        .selectFrom(Worker.WORKER)
                        .where()
                        .fetch();
        System.out.println(workerRecord);
    }

    public static void insertOrganizationAPI(DataSource dataSource, String orgName,Integer orgHeadId)
    {
        DSL.using(dataSource, SQLDialect.POSTGRES)
                .insertInto(ORGANIZATION)
                .set(ORGANIZATION.ORGANIZATIONNAME, orgName)
                .set(ORGANIZATION.ORGANIZATION_ORGANIZATIONID, orgHeadId)
                .execute();
    }


    public static void insertWorkerAPI(DataSource dataSource, String workerName,
                                    Integer workerOrgId, Integer workerWorkerId)
    {
        DSL.using(dataSource, SQLDialect.POSTGRES)
                .insertInto(Worker.WORKER)
                .set(Worker.WORKER.WORKERNAME, workerName)
                .set(Worker.WORKER.WORKER_ORGANIZATIONID, workerOrgId)
                .set(Worker.WORKER.WORKER_WORKERID, workerWorkerId)
                .execute();
    }

    public static  void updateOrganizationAPI(DataSource dataSource, Integer orgId,
                                           String orgName,Integer orgHeadId, String newOrgName, Integer newOrgHeadId)
    {
        DSL.using(dataSource, SQLDialect.POSTGRES)
                .insertInto(ORGANIZATION)
                .set(ORGANIZATION.ORGANIZATIONID, orgId)
                .set(ORGANIZATION.ORGANIZATIONNAME, orgName)
                .set(ORGANIZATION.ORGANIZATION_ORGANIZATIONID, orgHeadId)
                .onConflict()
                .doUpdate()
                .set(ORGANIZATION.ORGANIZATIONNAME, newOrgName)
                .set(ORGANIZATION.ORGANIZATION_ORGANIZATIONID, newOrgHeadId)
                .execute();
    }


    public static  void updateWorkerAPI(DataSource dataSource, Integer workerID, String workerName,
                                        Integer workerOrgId, Integer workerWorkerId, String newWorkerName,
                                        Integer newWorkerOrgId, Integer newWorkerWorkerID)
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
                .set(Worker.WORKER.WORKER_ORGANIZATIONID, newWorkerOrgId)
                .set(Worker.WORKER.WORKER_WORKERID, newWorkerWorkerID)
                .execute();
    }


    public static void deleteOrganizationAPI(DataSource dataSource, Integer orgId)
    {
        DSL.using(dataSource, SQLDialect.POSTGRES)
                .delete(ORGANIZATION)
                .where(ORGANIZATION.ORGANIZATIONID.eq(orgId))
                .execute();
    }


    public static void deleteWorkerAPI(DataSource dataSource, Integer workerId)
    {
        DSL.using(dataSource, SQLDialect.POSTGRES)
                .delete(Worker.WORKER)
                .where(Worker.WORKER.WORKERID.eq(workerId))
                .execute();
    }


    public static void getOrganizationByNameAPI(DataSource dataSource, String nameOrg)
    {
        //ЛУЧШЕ сделать, что поле содержит строку, а не .eq(строка)
        Result<OrganizationRecord> organizationRecord =
                DSL.using(dataSource, SQLDialect.POSTGRES)
                        .selectFrom(ORGANIZATION)
                        .where(ORGANIZATION.ORGANIZATIONNAME.eq(nameOrg))
                        .fetch();
        System.out.println(organizationRecord);

    }

    public static void getWorkerByNameAPI(DataSource dataSource, String workerName)
    {
        Result<WorkerRecord> workerRecord =
                DSL.using(dataSource, SQLDialect.POSTGRES)
                        .selectFrom(Worker.WORKER)
                        .where(Worker.WORKER.WORKERNAME.eq(workerName))
                        .fetch();
        System.out.println(workerRecord);
    }



    /*

    !!!Не нужно, сделаю выпадающие спискм в интерфейсе!!!

    public static boolean isBossFromSameOrg(DataSource dataSource, String workerName,
                                            Integer workerOrgId, Integer workerWorkerId)
    {
        Result bossOrgId =
                DSL.using(dataSource, SQLDialect.POSTGRES)
                .select(Worker.WORKER.WORKER_ORGANIZATIONID)
                .from(Worker.WORKER)
                .where(Worker.WORKER.WORKERID.eq(workerWorkerId))
                .fetch();

        if (bossOrgId == workerOrgId)
        return ;
    }
    */



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
