package vn.primary.store.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.primary.common.config.security.JwtTokenProvider;
import vn.primary.common.exception.BaseException;
import vn.primary.common.msg.Msg;
import vn.primary.common.service.AbstractBaseService;
import vn.primary.common.util.DigestUtil;
import vn.primary.store.dao.model.UserEntity;
import vn.primary.store.dao.repository.UserRepository;
import vn.primary.store.dto.LoginDTO;
import vn.primary.store.dto.UserDTO;
import vn.primary.store.enums.RoleEnum;

@Service
public class UserServiceImpl extends
    AbstractBaseService<UserEntity, UserDTO, UserRepository> implements UserService {

  @Autowired
  private UserRepository repository;

  @Autowired
  private JwtTokenProvider jwtTokenProvider;

  @Override
  protected UserRepository getRepository() {
    return repository;
  }

  @Override
  public Map<String, Object> validateLogin(LoginDTO loginDTO) {
    String username = loginDTO.getUsername();
    String password = loginDTO.getPassword();

    if (username == null) {
      throw new BaseException(1001, Msg.getMessage("user.name.null"));
    }

    if (password == null) {
      throw new BaseException(1002, Msg.getMessage("pass.word.null"));
    }
    UserEntity user = repository.findByUsername(username)
        .orElseThrow(() -> new BaseException(1004, Msg.getMessage("user.name.not.exists")));

    if (!user.getPassword().equals(getHassPassword(password))) {
      throw new BaseException(1005, Msg.getMessage("password.invalid"));
    }

    Map<String, Object> additionalInformation = new HashMap<>();
    additionalInformation.put("name", user.getName());
    additionalInformation.put("username", user.getUsername());
    additionalInformation.put("phone", user.getPhoneNumber());

    JwtTokenProvider.JwtTokenProperties jwtTokenProperties = JwtTokenProvider.JwtTokenProperties
        .builder()
        .id(user.getId())
        .username(user.getUsername())
        .fullName(user.getUsername())
        .jwtAdditionalInformation(additionalInformation).build();

    return jwtTokenProvider.generateToken(jwtTokenProperties);
  }

  @Override
  public Map<String, Object> registerUser(LoginDTO loginDTO) {
    String username = loginDTO.getUsername();
    String password = loginDTO.getPassword();

    if (username == null) {
      throw new BaseException(1001, Msg.getMessage("user.name.null"));
    }

    if (password == null) {
      throw new BaseException(1002, Msg.getMessage("pass.word.null"));
    }

    UserEntity user = new UserEntity();
    user.setUsername(username);
    user.setPassword(getHassPassword(password));
    user.setRole(RoleEnum.USER);

    repository.save(user);

    Map<String, Object> objectHashMap = new HashMap<>();
    objectHashMap.put("name", user.getName());
    objectHashMap.put("username", user.getUsername());
    objectHashMap.put("password", user.getPassword());
    objectHashMap.put("phone", user.getPhoneNumber());
    objectHashMap.put("role", user.getRole());

    JwtTokenProvider.JwtTokenProperties jwtTokenProperties = JwtTokenProvider.JwtTokenProperties
        .builder()
        .id(user.getId())
        .username(user.getUsername())
        .fullName(user.getUsername())
        .jwtAdditionalInformation(objectHashMap).build();

    return jwtTokenProvider.generateToken(jwtTokenProperties);
  }

  public String getHassPassword(String password) {
    return DigestUtil.sha256Hex(password);
  }
}
