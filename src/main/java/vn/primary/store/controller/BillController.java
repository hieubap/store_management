package vn.primary.store.controller;

import java.time.ZonedDateTime;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.primary.common.controller.BaseController;
import vn.primary.common.dto.ResponseMsg;
import vn.primary.store.dto.BillDTO;
import vn.primary.store.dto.OrderDTO;
import vn.primary.store.service.BillService;

@RestController
@RequestMapping(value = "/bill")
public class BillController extends BaseController<BillDTO, BillService> {
  @Autowired
  private BillService billService;

  @Override
  protected BillService getService() {
    return billService;
  }

  @PostMapping(value = "/order")
  public ResponseEntity<ResponseMsg> orderFood(@RequestBody OrderDTO billDTO, HttpServletRequest httpServletRequest){
    return response(billService.orderFood(billDTO,httpServletRequest));
  }

  @PutMapping(value = "/{id}/received")
  public ResponseEntity<ResponseMsg> received(@PathVariable(value = "id") Long idBill, HttpServletRequest httpServletRequest){
    return response(billService.received(idBill,httpServletRequest));
  }

  @GetMapping(value = "/find_all")
  public List<BillDTO> findAll(){
    return billService.findAllBill();
  }

  @GetMapping(value = "/{id}/find")
  public BillDTO findById(@PathVariable Long id){
    return billService.findBillById(id);
  }

  @GetMapping("/date")
  @Transactional
  public ResponseEntity<ResponseMsg> getByType(@RequestParam ZonedDateTime fromDate,
      @RequestParam ZonedDateTime toDate) {
    return response(billService.findByDate(fromDate, toDate));
  }
}
