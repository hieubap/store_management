package vn.primary.store.service;

import java.util.List;
import vn.primary.common.service.BaseService;
import vn.primary.store.dto.RoleDTO;

public interface RoleService extends BaseService<RoleDTO> {
  public List<RoleDTO> getAll();
}
