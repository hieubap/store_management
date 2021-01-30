//package vn.isofh.store.save;
//
//import com.isofh.service.model.HistoryAuditEntity;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//
//public interface HistoryScheduleRepository extends CrudRepository<HistoryAuditEntity,Long> {
//  @Query(value = "select m.* from history_schedule m"
//      + " where true "
//      + " and (m.id_device = :#{#id} "
//      + " or :#{#id} is null) "
//      , countQuery = "select count(m.id) from history_schedule m"
//      + " where true "
//      + " and (m.id_device = :#{#id} "
//      + " or :#{#id} is null) "
////      + " ORDER BY  n.created_date DESC"
//      ,
//      nativeQuery = true)
//  Page<HistoryAuditEntity> getHistoryOfDevice(Long id, Pageable pageable);
//}