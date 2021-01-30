package vn.primary.store.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import vn.primary.common.controller.BaseResponseController;
import vn.primary.common.dto.ResponseMsg;
import vn.primary.store.dto.LoginDTO;
import vn.primary.store.service.UserService;


@RestController
@RequestMapping("/auth")
public class AuthController extends BaseResponseController {

  @Autowired
  private UserService userService;

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  @Transactional(readOnly = true)
  public ResponseEntity<ResponseMsg> login(@Valid @RequestBody LoginDTO loginDto) {
    return response(userService.validateLogin(loginDto));
  }

  @Transactional
  @RequestMapping(value = "/register", method = RequestMethod.POST)
  public ResponseEntity<ResponseMsg> register(@Valid @RequestBody LoginDTO loginDto) {
    return response(userService.registerUser(loginDto));
  }

}
