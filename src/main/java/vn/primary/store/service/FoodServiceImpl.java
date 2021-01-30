package vn.primary.store.service;

import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.primary.common.service.AbstractBaseService;
import vn.primary.store.exception.NullException;
import vn.primary.store.dao.model.FoodEntity;
import vn.primary.store.dao.repository.FoodRepository;
import vn.primary.store.dto.FoodDTO;

@Service
public class FoodServiceImpl extends AbstractBaseService<FoodEntity, FoodDTO, FoodRepository> implements FoodService {
    @Autowired
    private FoodRepository repository;

    @Override
    protected FoodRepository getRepository() {
        return repository;
    }

    @Override
    public FoodDTO save(FoodDTO foodDTO) {
        preFoodDTO(foodDTO);

        FoodEntity foodEntity = new FoodEntity();
        foodEntity.setName(foodDTO.getName());

        repository.save(foodEntity);

//        Map<String,Object> map = new HashMap<>();
//        map.put("name",foodEntity.getName());
//        map.put("price",foodEntity.getPrice());

        return foodDTO;
    }

//    @Override
//    public Map<String, Object> create(FoodDTO foodDTO) {
//        preFoodDTO(foodDTO);
//
//        FoodEntity foodEntity = new FoodEntity();
//        foodEntity.setName(foodDTO.getName());
//
//        repository.save(foodEntity);
//
//        Map<String,Object> map = new HashMap<>();
//        map.put("name",foodEntity.getName());
//        map.put("price",foodEntity.getPrice());
//
//        return map;
//    }
//    @Override
//    public List<FoodEntity> getListFood() {
//        return repository.findAll();
//    }


    @Override
    public Page<FoodDTO> search(FoodDTO dto, Pageable pageable) {
        return super.search(dto, pageable);
    }

    private void preFoodDTO(FoodDTO foodDTO){
        if (Strings.isNullOrEmpty(foodDTO.getName())){
            throw new NullException("food name is empty or null. enter 'name' ",foodDTO);
        }
    }
}
