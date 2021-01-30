//package vn.isofh.store.save;
//
//import com.isofh.service.dto.HistoryAuditDTO;
//import com.isofh.service.model.HistoryScheduleEntity;
//import com.isofh.service.model.ResultEntity;
//import com.isofh.service.service.BaseService;
//import com.isofh.service.service.HistoryScheduleService;
//import java.util.ArrayList;
//import java.util.List;
//import org.json.JSONObject;
//import org.springframework.data.domain.Page;
//import org.springframework.stereotype.Service;
//
//@Service
//public class HistoryScheduleServiceImpl extends BaseService implements HistoryScheduleService {
//
//  @Override
//  public ResultEntity create(Object object) throws Exception {
//    init(object);
//    JSONObject jsonData = getJsonData(object);
//    HistoryScheduleEntity entity = getEntityById(historyScheduleRepository,getLong("id_schedule",jsonData));
//    historyScheduleRepository.save(entity);
//
//    return ok(convertEntityToDTO(entity));
//  }
//
//  @Override
//  public ResultEntity update(Long id, Object object) throws Exception {
//    return null;
//  }
//
//  @Override
//  public ResultEntity delete(Long id) throws Exception {
//    return null;
//  }
//
//  @Override
//  public ResultEntity getDetail(Long id) throws Exception {
//    return null;
//  }
//
//  @Override
//  public ResultEntity search(Long id, Integer page, Integer size) throws Exception {
//    List<HistoryAuditDTO> list = new ArrayList<>();
//    Page<HistoryScheduleEntity> listEntity = historyScheduleRepository.getHistoryOfDevice(id,getDefaultPage(page,size));
//
//    for (HistoryScheduleEntity i : listEntity){
//      list.add(convertEntityToDTO(i));
//    }
//
//    return ok(list);
//  }
//
//  public HistoryAuditDTO convertEntityToDTO(HistoryScheduleEntity entity){
//    HistoryAuditDTO dto = new HistoryAuditDTO();
//    dto.setUnitUse(entity.getUnitUse());
//    dto.setStatus(entity.getStatus());
//    dto.setDateMaintenance(entity.getDateMaintenance());
//    dto.setUserMaintenance(entity.getUserMaintenance());
//    dto.setUnitMaintenance(entity.getUnitMaintenance());
//    dto.setDateCreate(entity.getDateCreate());
//    dto.setUserCreate(entity.getUserCreate());
//    dto.setDateUpdate(entity.getDateUpdate());
//    dto.setUserUpdate(entity.getUserUpdate());
//
//    return dto;
//  }
//}