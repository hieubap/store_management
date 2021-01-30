package vn.primary.store.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.primary.common.service.AbstractBaseService;
import vn.primary.store.dao.model.RoleEntity;
import vn.primary.store.dao.repository.RoleRepository;
import vn.primary.store.dto.RoleDTO;

@Service
public class RoleServiceImpl extends AbstractBaseService<RoleEntity, RoleDTO, RoleRepository> implements RoleService {
  @Autowired
  private RoleRepository roleRepository;

  @Override
  protected RoleRepository getRepository() {
    return roleRepository;
  }

  @Override
  public List<RoleDTO> getAll() {
    List<RoleEntity> list = roleRepository.findAll();
    List<RoleDTO> listDTO = new ArrayList<>();

    for (RoleEntity r : list){
      RoleDTO dto = new RoleDTO();
      dto.setRole(r.getRole());
      dto.setName(r.getName());
      listDTO.add(dto);
    }
    return listDTO;
  }
}
