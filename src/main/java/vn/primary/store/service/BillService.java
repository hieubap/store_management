package vn.primary.store.service;

import java.time.ZonedDateTime;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import vn.primary.common.service.BaseService;
import vn.primary.store.dao.model.dashboard.DashboardBillEntity;
import vn.primary.store.dto.BillDTO;
import vn.primary.store.dto.OrderDTO;

public interface BillService extends BaseService<BillDTO> {
  public BillDTO orderFood(OrderDTO orderDTO, HttpServletRequest httpServletRequest);
  public BillDTO received(Long idBill,HttpServletRequest httpServletRequest);
  public BillDTO findBillById(Long id);
  public List<BillDTO> findAllBill();
  public List<DashboardBillEntity> findByDate(ZonedDateTime from, ZonedDateTime to);

}
