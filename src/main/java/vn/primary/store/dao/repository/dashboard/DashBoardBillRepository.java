package vn.primary.store.dao.repository.dashboard;

import java.time.ZonedDateTime;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import vn.primary.store.dao.model.dashboard.DashboardBillEntity;

@Repository
public class DashBoardBillRepository {

  @Autowired
  @Qualifier("entityManagerFactory")
  private EntityManager firstDataManager;

  public List<DashboardBillEntity> getByIdUser(ZonedDateTime fromDate, ZonedDateTime toDate) {

    List<DashboardBillEntity> dtos = firstDataManager
        .createNamedStoredProcedureQuery("billByDate")
        .setParameter("from_date", fromDate)
        .setParameter("to_date", toDate)
        .getResultList();

    return dtos;
  }
}
