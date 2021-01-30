package vn.primary.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.primary.common.controller.BaseController;
import vn.primary.common.dto.ResponseMsg;
import vn.primary.store.dto.RoleDTO;
import vn.primary.store.service.RoleService;

@RestController
@RequestMapping(value = "/admin/role")
@PreAuthorize("hasAnyRole('SUPER_ADMIN')")
public class RoleController extends BaseController<RoleDTO, RoleService> {
  @Autowired
  private RoleService roleService;

  @Override
  protected RoleService getService() {
    return roleService;
  }

  @GetMapping(value = "/list")
  public ResponseEntity<ResponseMsg> list(){
    return response(roleService.getAll());
  }
}
