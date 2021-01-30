package vn.primary.store.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.primary.common.controller.BaseController;
import vn.primary.store.dto.UserDTO;
import vn.primary.store.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController<UserDTO, UserService> {
  @Autowired
  private UserService userService;

  @Override
  protected UserService getService() {
    return userService;
  }

  @GetMapping(value = "/infor")
  public ResponseEntity<?>infor() {
    Map<String,String> object = new HashMap<>();
    object.put("namefood","banh mi");
    object.put("information","banh mi ngon gia re");
    return response(object);
  }

}
