package vn.primary.store.service;

import java.util.Map;
import vn.primary.common.service.BaseService;
import vn.primary.store.dto.LoginDTO;
import vn.primary.store.dto.UserDTO;

public interface UserService extends BaseService<UserDTO> {

  Map<String, Object> validateLogin(LoginDTO dto);

  Map<String, Object> registerUser(LoginDTO dto);
}
