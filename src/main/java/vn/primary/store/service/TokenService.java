package vn.primary.store.service;

import javax.servlet.http.HttpServletRequest;
import vn.primary.store.dao.model.UserEntity;

public interface TokenService {
  public UserEntity getUserFromToken(HttpServletRequest httpServletRequest);
}
