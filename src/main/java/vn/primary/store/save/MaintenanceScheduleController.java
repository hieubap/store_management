//package vn.isofh.store.save;
//
//import com.isofh.service.constant.DefaultConst;
//import com.isofh.service.constant.field.CommonField;
//import com.isofh.service.service.DeviceAuditService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.repository.query.Param;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import vn.isofh.common.controller.BaseController;
//
//@RestController
//@RequestMapping(value = "/maintenance_schedule")
//public class DeviceAuditController extends BaseController {
//
//  @Autowired
//  public DeviceAuditService service;
//
//  @GetMapping(path = "/search")
//  public ResponseEntity<?> search(
//      @RequestParam(value = CommonField.PAGE, required = false, defaultValue = DefaultConst.PAGE) Integer page,
//      @RequestParam(value = CommonField.SIZE, required = false, defaultValue = DefaultConst.SIZE) Integer size,
//      @RequestBody Object data,
//      @Param(value = "id") Long id
//  ) {
//    try {
//        return response(service.search(data, page, size));
//    } catch (Exception ex) {
//      return response(error(ex));
//    }
//  }
//
//
//  @PostMapping(value = "/create")
//  public ResponseEntity<?> create(@RequestBody Object object) {
//    try {
//      return response(service.create(object));
//    } catch (Exception ex) {
//      return response(error(ex));
//    }
//  }
//
//  @PutMapping(value = "/appointment_schedule")
//  public ResponseEntity<?> appointment_schedule(@Param(value = "id") Long id) {
//    try {
//      return response(service.appointmentSchedule(id));
//    } catch (Exception ex) {
//      return response(error(ex));
//    }
//  }
//
//  @PutMapping(value = "/cancel_appointment_schedule")
//  public ResponseEntity<?> cancel_appointment_schedule(@Param(value = "id") Long id) {
//     try {
//       return response(service.cancelAppointmentSchedule(id));
//     } catch (Exception ex) {
//       return response(error(ex));
//     }
//   }
//  @PutMapping(value = "/confirm_chedule")
//  public ResponseEntity<?> confirm(@Param(value = "id") Long id) {
//    try {
//      return response(service.confirmSchedule(id));
//    } catch (Exception ex) {
//      return response(error(ex));
//    }
//  }
//
//  @PutMapping(value = "/cancel_schedule")
//  public ResponseEntity<?> cancel_schedule(@Param(value = "id") Long id) {
//    try {
//      return response(service.cancelConfirmSchedule(id));
//    } catch (Exception ex) {
//      return response(error(ex));
//    }
//  }
//
//  @PostMapping(value = "/confirm_maintenance")
//  public ResponseEntity<?> confirm_maintenance(@RequestBody Object object) {
//     try {
//       return response(service.approvedMaintenance(object));
//     } catch (Exception ex) {
//       return response(error(ex));
//     }
//   }
//
//  @PutMapping(value = "/update/{id}")
//  public ResponseEntity<?> update(@RequestBody Object object, @PathVariable Long id) {
//    try {
//      return response(service.update(id, object));
//    } catch (Exception ex) {
//      return response(error(ex));
//    }
//  }
//
//  @DeleteMapping(value = "/delete/{id}")
//  public ResponseEntity<?> delete(@PathVariable Long id) {
//    try {
//      return response(service.delete(id));
//    } catch (Exception ex) {
//      return response(error(ex));
//    }
//  }
//
//}