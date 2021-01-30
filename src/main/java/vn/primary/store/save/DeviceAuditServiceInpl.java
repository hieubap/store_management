//package vn.isofh.store.save;
//
//import com.isofh.service.dto.DeviceDetailDTO;
//import com.isofh.service.dto.MaintenanceScheduleSearchDTO;
//import com.isofh.service.enums.DeviceAuditStatus;
//import com.isofh.service.model.DeviceEntity;
//import com.isofh.service.model.DeviceMaintenanceEntity;
//import com.isofh.service.model.HistoryScheduleEntity;
//import com.isofh.service.model.DeviceAuditEntity;
//import com.isofh.service.model.ResultEntity;
//import com.isofh.service.model.UserEntity;
//import com.isofh.service.result.IMapData;
//import com.isofh.service.service.BaseService;
//import com.isofh.service.service.DeviceAuditService;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import org.json.JSONObject;
//import org.springframework.data.domain.Page;
//import org.springframework.stereotype.Service;
//
//@Service
//public class DeviceAuditServiceInpl extends BaseService implements
//    DeviceAuditService,
//    IMapData<DeviceAuditEntity> {
//
//  /**
//   * B.1
//   */
//  @Override
//  public ResultEntity create(Object object) throws Exception {
//    init(object);
//    JSONObject jsonData1 = getJsonData(object);
//    JSONObject jsonData = getJSONObject(BaseService.MAINTENANCE_SCHEDULE, jsonData1);
//    DeviceAuditEntity data = getObject(BaseService.MAINTENANCE_SCHEDULE,
//        DeviceAuditEntity.class, jsonData1);
//
//    DeviceEntity device = getEntityById(deviceRepository, getLong("id_device", jsonData));
//    if (device == null) {
//      throw new Exception("'id_device' is null or empty or not exist");
//    }
//    if (data.getDevice() == null) {
//      throw new Exception("'id_device' is null or empty or not exist");
//    }
//    if (data.getPeriodic() == null) {
//      throw new Exception("'id_device' is null or empty or not exist");
//    }
//    if (data.getDateApplication() == null) {
//      throw new Exception("'id_device' is null or empty or not exist");
//    }
//
//    data.setDevice(device);
//    data.setTimes(0);
//    data.setStatus(DeviceAuditStatus.WAIT_MAINTENANCE);
//    data.setCreateDate(LocalDate.now());
//    data.setUpdateDate(LocalDate.now());
//
//    DeviceAuditEntity entity = maintenanceScheduleRepository.save(data);
//
//    return ok(convertEntityToDTO(entity));
//  }
//
//  /**
//   * 2.3
//   */
//  @Override
//  public ResultEntity confirmSchedule(Long id) throws Exception {
//    // set status maintenance entity to confirm maintenance from department
//    DeviceAuditEntity maintenanceSchedule = getEntityById(maintenanceScheduleRepository,id);
//    maintenanceSchedule.setStatus(DeviceAuditStatus.DEPARTMENT_CONFIRM_MAINTENANCE);
//    maintenanceScheduleRepository.save(maintenanceSchedule);
//
//    return ok(convertEntityToDTO(maintenanceSchedule));
//  }
//
//  /**
//   * 2.4
//   */
//  @Override
//  public ResultEntity cancelConfirmSchedule(Long id) throws Exception {
//    init(id);
//    JSONObject jsonData = getJsonData(id);
//
//    // set status maintenance entity to confirm maintenance from department
//    DeviceAuditEntity maintenanceSchedule = getEntityById(maintenanceScheduleRepository,getLong("id_maintenance_schedule",jsonData));
//    maintenanceSchedule.setStatus(DeviceAuditStatus.DEPARTMENT_CANCEL_SCHEDULE);
//    maintenanceScheduleRepository.save(maintenanceSchedule);
//
//    return ok(convertEntityToDTO(maintenanceSchedule));
//  }
//
//  /**
//   * B.3
//   */
//  @Override
//  public ResultEntity appointmentSchedule(Long id) throws Exception {
//    DeviceAuditEntity entity = getEntityById(maintenanceScheduleRepository,id);
//    // id of maintenance schedule must exactly
//    if (entity == null) {
//      throw new Exception("id is null or empty or not exist.");
//    }
//
//    // set status schedule is wait department confirm
////    entity.setStatus(DeviceAuditStatus.WAIT_DEPARTMENT_CONFIRM);
//    maintenanceScheduleRepository.save(entity);
//
//    return ok(convertEntityToDTO(entity));
//  }
//
//  /**
//   * B.4
//   */
//  @Override
//  public ResultEntity cancelAppointmentSchedule(Long id) throws Exception {
//    // id_device must exactly
//    DeviceAuditEntity entity = getEntityById(maintenanceScheduleRepository,id);
//    if (entity == null) {
//      throw new Exception("id is null or empty or not exist.");
//    }
//
//    // change status maintenance schedule to wait maintenance if admin device
////    entity.setStatus(DeviceAuditStatus.WAIT_MAINTENANCE);
//    maintenanceScheduleRepository.save(entity);
//
//    return ok(convertEntityToDTO(entity));
//  }
//
//  /**
//   * B.5
//   */
//  @Override
//  public ResultEntity approvedMaintenance(Object object) throws Exception {
//    init(object);
//    JSONObject jsonData = getJsonData(object);
//
//    // set status maintenance entity to confirm maintenance
//    DeviceAuditEntity maintenanceSchedule = getEntityById(maintenanceScheduleRepository,getLong("id_maintenance_schedule",jsonData));
//    maintenanceSchedule.setStatus(DeviceAuditStatus.CONFIRM_MAINTENANCE);
//    maintenanceSchedule.setTimes(maintenanceSchedule.getTimes()+1); // increase time one
//    maintenanceScheduleRepository.save(maintenanceSchedule);
//
//    // save report maintenance
//    DeviceMaintenanceEntity deviceMaintenanceEntity = getObject("reportMaintenance",DeviceMaintenanceEntity.class,jsonData);
//    deviceMaintenanceRepository.save(deviceMaintenanceEntity);
//
//    // save history after admin vt confirm maintenance
//    HistoryScheduleEntity historyEntity = new HistoryScheduleEntity();
//    historyEntity.setIdDevice(maintenanceSchedule.getDevice().getId());
//    historyEntity.setUnitUse(maintenanceSchedule.getUnit_use());
//    historyEntity.setStatus(DeviceAuditStatus.DEPARTMENT_CANCEL_SCHEDULE.name());
//    historyEntity.setDateMaintenance(maintenanceSchedule.getDate_maintenance());
//    historyEntity.setUserMaintenance(maintenanceSchedule.getUser_maintenance());
//    historyEntity.setUnitMaintenance(maintenanceSchedule.getUnit_maintenance());
//    historyEntity.setDateCreate(maintenanceSchedule.getCreateDate());
//    historyEntity.setUserCreate(maintenanceSchedule.getUser_create());
//    historyEntity.setDateUpdate(maintenanceSchedule.getUpdateDate());
//    historyEntity.setUserUpdate(maintenanceSchedule.getUser_update());
//    historyScheduleRepository.save(historyEntity);
//
//    return ok(convertEntityToDTO(maintenanceSchedule));
//  }
//
//  @Override
//  public ResultEntity search(Object dto, Integer page, Integer size)
//      throws Exception {
//    init();
//    Page<DeviceAuditEntity> results = maintenanceScheduleRepository
//        .search(dto, getDefaultPage(page, size));
//
//    Map<String, Object> result = getResult(results.getTotalElements(),
//        getMapData(results.getContent()));
//
//    return ok(result);
//  }
//
//  @Override
//  public Map<String, Object> getMapData(DeviceAuditEntity entity) {
//    Map<String, Object> map = new HashMap<>();
//    map.put(BaseService.MAINTENANCE_SCHEDULE, entity);
//    return map;
//  }
//
//  private List<DeviceDetailDTO> getMapData(List<DeviceAuditEntity> entities) {
//    List<DeviceDetailDTO> mapResults = new ArrayList<>();
//    for (DeviceAuditEntity entity : entities) {
//      mapResults.add(convertEntityToDTO(entity));
//    }
//    return mapResults;
//  }
//
//  @Override
//  public DeviceDetailDTO convertEntityToDTO(DeviceAuditEntity entity) {
//    DeviceDetailDTO dto = new DeviceDetailDTO();
//    dto.setCodeDevice(entity.getDevice().getCode());
//    dto.setNameDevice(entity.getDevice().getDeviceCommercialName().getName());
//    dto.setTypeDevice(entity.getDevice().getDeviceCommercialName().getDeviceType().getName());
//    dto.setSerial(entity.getDevice().getSerial());
//    dto.setModel(entity.getDevice().getCategory());
//    dto.setPrice(entity.getDevice().getPrice());
//    dto.setManufacturer(entity.getDevice().getManufacturer().getName());
//    dto.setCountryOfManufacture(entity.getDevice().getCountry().getName());
//    dto.setYearOfManufacture(entity.getDevice().getCreatedYear());
//    if (entity.getDevice().getDateInstallation() != null)
//    dto.setDatePuttingIntoUse(entity.getDevice().getDateInstallation().toLocalDate());
//    dto.setYearOfPuttingUse(entity.getDevice().getUsedYear());
//    dto.setReturnStoreDay(entity.getDevice().getReturnStoreDate());
//    dto.setFacultyUse(entity.getDevice().getFacility().getName());
//
//    dto.setPeriodic(entity.getPeriodic());
//    dto.setDateApplication(entity.getDateApplication());
//
//    dto.setUnit_maintenance(entity.getUnit_maintenance());
//    dto.setUser_maintenance(entity.getUser_maintenance());
//    dto.setUnit_use(entity.getUnit_use());
//    dto.setDate_maintenance(entity.getDate_maintenance());
//    dto.setTimes(entity.getTimes());
//    dto.setStatus(entity.getStatus());
//    dto.setNote(entity.getNote());
//    dto.setCreateDate(entity.getCreateDate());
//    if (entity.getUser_create() != null) {
//      dto.setUser_create(entity.getUser_create().getName());
//    }
//    dto.setUpdateDate(entity.getUpdateDate());
//    if (entity.getUser_update() != null) {
//      dto.setUser_update(entity.getUser_update().getName());
//    }
//
//    return dto;
//  }
//
//  @Override
//  public ResultEntity update(Long id, Object object) throws Exception {
//    init(object);
//    JSONObject jsonData1 = getJsonData(object);
//    JSONObject jsonData = getJSONObject(BaseService.MAINTENANCE_SCHEDULE, jsonData1);
//    DeviceAuditEntity data = getObject(BaseService.MAINTENANCE_SCHEDULE,
//        DeviceAuditEntity.class, jsonData);
//    DeviceAuditEntity entity = getEntityById(maintenanceScheduleRepository, id);
//
//    UserEntity userCreate = getEntityById(userRepository, getLong("id_user_create", jsonData));
//    if (userCreate != null) {
//      data.setUser_create(userCreate);
//    }
//
//    UserEntity userUpdate = getEntityById(userRepository, getLong("id_user_update", jsonData));
//    if (userUpdate != null) {
//      data.setUser_update(userUpdate);
//    }
//
//    DeviceEntity device = getEntityById(deviceRepository, getLong("id_device", jsonData));
//    if (device != null) {
//      data.setDevice(device);
//    }
//
////    entity.setDevice(data.getDevice());
//    entity.setPeriodic(data.getPeriodic());
//    entity.setDateApplication(data.getDateApplication());
//    entity.setUnit_maintenance(data.getUnit_maintenance());
//    entity.setUnit_use(data.getUnit_use());
//    entity.setUser_maintenance(data.getUser_maintenance());
//    entity.setUnit_use(data.getUnit_use());
//    entity.setDate_maintenance(data.getDate_maintenance());
//    entity.setTimes(data.getTimes());
//    entity.setStatus(data.getStatus());
//    entity.setNote(data.getNote());
//    entity.setUpdateDate(data.getUpdateDate());
//    entity.setUser_update(data.getUser_update());
//
//    return ok(maintenanceScheduleRepository.save(entity));
//  }
//
//  @Override
//  public ResultEntity delete(Long id) throws Exception {
//    maintenanceScheduleRepository.deleteById(id);
//
//    return ok();
//  }
//}
