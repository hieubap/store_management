package vn.primary.store.dao.repository;

import java.util.Optional;
import vn.primary.common.dao.repository.BaseRepository;
import vn.primary.store.dao.model.UserEntity;
import vn.primary.store.dto.UserDTO;

public interface UserRepository extends BaseRepository<UserEntity, UserDTO, Long> {
  public Optional<UserEntity> findByUsername(String username);
}
