package vn.primary.store.service;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.primary.common.service.AbstractBaseService;
import vn.primary.store.dao.model.StoreEntity;
import vn.primary.store.dao.model.UserEntity;
import vn.primary.store.dao.repository.StoreRepository;
import vn.primary.store.dto.StoreDTO;
import vn.primary.store.exception.EmptyException;
import vn.primary.store.exception.NullException;

@Service
public class StoreServiceImpl extends AbstractBaseService<StoreEntity, StoreDTO, StoreRepository> implements StoreService{
    @Autowired
    private StoreRepository repository;

    @Autowired
    private TokenService tokenService;

    @Override
    protected StoreRepository getRepository() {
        return repository;
    }

    @Override
    public StoreDTO registerStore(StoreDTO storeDTO, HttpServletRequest httpServletRequest) {
        UserEntity user = tokenService.getUserFromToken(httpServletRequest);

        return null;
    }

    private void preStoreDTO(StoreDTO storeDTO){
        if (storeDTO.getName() == null)
            throw new NullException("'name' is null",storeDTO);
        if (storeDTO.getName().isEmpty()){
            throw new EmptyException("'name' is empty",storeDTO);
        }

        if (storeDTO.getPhoneNumber() == null)
            throw new NullException("'phoneNumber' is null",storeDTO);
        if (storeDTO.getPhoneNumber().isEmpty()){
            throw new EmptyException("'phoneNumber' is empty",storeDTO);
        }
    }
}
