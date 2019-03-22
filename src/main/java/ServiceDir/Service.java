package ServiceDir;

import RepoDir.Repo;
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
        Repo.getOrganizationsAPI(dataSource);
    }

    public static void getWorkers(DataSource dataSource)
    {
        Repo.getWorkersAPI(dataSource);
    }

    public static void insertOrganization(DataSource dataSource, String orgName,Integer orgHeadId)
    {
        Repo.insertOrganizationAPI(dataSource, orgName, orgHeadId);
    }

    public static void insertWorker(DataSource dataSource, String workerName,
                                    Integer workerOrgId, Integer workerWorkerId)
    {
        // Проверка, что босс из этой же организации
        // !!!Сделаю выпадающие списки в интерфейсе!!!

        Repo.insertWorkerAPI(dataSource, workerName, workerOrgId, workerWorkerId);

    }

    public static  void updateOrganization(DataSource dataSource, Integer orgId,
                                           String orgName,Integer orgHeadId, String newOrgName, Integer newOrgHeadId)
    {

        Repo.updateOrganizationAPI(dataSource, orgId, orgName, orgHeadId, newOrgName, newOrgHeadId);
    }

    public static  void updateWorker(DataSource dataSource, Integer workerID, String workerName,
                                     Integer workerOrgId, Integer workerWorkerId, String newWorkerName,
                                     Integer newWorkerOrgId, Integer newWorkerWorkerId)
    {
        // Проверка, что руководитель из этой же организации
        // !!!Сделаю выпадающие списки в интерфейсе!!!

        Repo.updateWorkerAPI(dataSource, workerID, workerName, workerOrgId,
                             workerWorkerId,newWorkerName, newWorkerOrgId, newWorkerWorkerId);
    }

    public static void deleteOrganization(DataSource dataSource, Integer orgId)
    {
        //Проверка: если у Организации нет дочерних элементов

        Repo.deleteOrganizationAPI(dataSource, orgId);
    }

    public static void deleteWorker(DataSource dataSource, Integer workerId)
    {
        //Проверка: если у Сотрудника нет дочерних элементов


        Repo.deleteWorkerAPI(dataSource, workerId);
    }





    public static void getOrganizationByName(DataSource dataSource, String orgName)
    {
        Repo.getOrganizationByNameAPI(dataSource, orgName);
    }

    public static void getWorkerByName(DataSource dataSource, String workerName)
    {
        Repo.getWorkerByNameAPI(dataSource, workerName);
    }




}
