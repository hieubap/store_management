package vn.primary.store.service;

import javax.servlet.http.HttpServletRequest;
import vn.primary.common.service.BaseService;
import vn.primary.store.dto.StoreDTO;

public interface StoreService extends BaseService<StoreDTO> {
  public StoreDTO registerStore(StoreDTO storeDTO, HttpServletRequest httpServletRequest);
}
