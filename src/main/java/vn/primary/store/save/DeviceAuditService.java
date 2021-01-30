//package vn.isofh.store.save;
//
//import com.isofh.service.dto.DeviceDetailDTO;
//import com.isofh.service.model.DeviceAuditEntity;
//import com.isofh.service.model.ResultEntity;
//
//public interface DeviceAuditService {
//
//  ResultEntity update(Long id, Object object) throws Exception;
//
//  ResultEntity delete(Long id) throws Exception;
//
//  /**
//   * search maintenance schedule by dto
//   */
//  ResultEntity search(Object dto, Integer page, Integer size)
//      throws Exception;
//
//  /**
//   * them moi
//   */
//  ResultEntity create(Object object) throws Exception;
//
//  /**
//   * admin vt send schedule and wait department confirm
//   */
//  ResultEntity appointmentSchedule(Long id) throws Exception;
//
//  /**
//   * admin vt cancel schedule them
//   */
//  ResultEntity cancelAppointmentSchedule(Long id) throws Exception;
//
//  /**
//   * admin khoa confirm schedule from admin vt
//   */
//  ResultEntity confirmSchedule(Long id) throws Exception;
//
//  /**
//   * admin khoa cancel confirm from admin vt
//   * @param id
//   */
//  ResultEntity cancelConfirmSchedule(Long id) throws Exception;
//
//  /**
//   * admin khoa / admin vt approved maintenance device
//   */
//  ResultEntity approvedMaintenance(Object o) throws Exception;
//
//  DeviceDetailDTO convertEntityToDTO(DeviceAuditEntity entity);
//}
