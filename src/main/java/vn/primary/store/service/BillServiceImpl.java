package vn.primary.store.service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.primary.common.service.AbstractBaseService;
import vn.primary.store.dao.model.dashboard.DashboardBillEntity;
import vn.primary.store.dao.repository.dashboard.DashBoardBillRepository;
import vn.primary.store.dao.model.BillEntity;
import vn.primary.store.dao.model.BillFoodEntity;
import vn.primary.store.dao.model.UserEntity;
import vn.primary.store.dao.repository.BillFoodRepository;
import vn.primary.store.dao.repository.BillRepository;
import vn.primary.store.dao.repository.FoodRepository;
import vn.primary.store.dto.BillDTO;
import vn.primary.store.dto.Food_On_Bill_DTO;
import vn.primary.store.dto.OrderDTO;
import vn.primary.store.dto.UserDTO;
import vn.primary.store.enums.OrderStatusEnum;
import vn.primary.store.exception.NullException;

@Service
public class BillServiceImpl extends
    AbstractBaseService<BillEntity, BillDTO, BillRepository> implements BillService {

  @Autowired
  private BillRepository billrepository;

  @Autowired
  private DashBoardBillRepository dashBoardBillRepository;

  @Autowired
  private BillFoodRepository billFoodRepository;

  @Autowired
  private FoodRepository foodRepository;

  @Autowired
  private TokenService tokenService;

  @Override
  protected BillRepository getRepository() {
    return billrepository;
  }

  @Override
  public BillDTO orderFood(OrderDTO orderDTO, HttpServletRequest httpServletRequest) {
    preOrderDTO(orderDTO);

    UserEntity userEntity = tokenService.getUserFromToken(httpServletRequest);

    BillEntity billEntity = new BillEntity();
    billEntity.setStatus(OrderStatusEnum.ORDER);
    billEntity.setUserEntity(userEntity);
    billrepository.save(billEntity);

    Long total = (long)0;
    for (Map.Entry<Long,Long> b : orderDTO.getListFood().entrySet()){
      // create bill_food
      BillFoodEntity bill_food = new BillFoodEntity();
      bill_food.setBill_id(billEntity.getId());
      bill_food.setFood_id(b.getKey());
      bill_food.setNumber(b.getValue());
      billFoodRepository.save(bill_food);

      total += foodRepository.findById(b.getKey()).get().getPrice()*b.getValue();
    }
    billEntity.setTotal(total);

    return convertBillEntityToBillDTO(billEntity);
  }

  @Override
  public BillDTO received(Long idBill,HttpServletRequest httpServletRequest) {
    BillEntity billEntity = billrepository.findById(idBill).get();
    billEntity.setStatus(OrderStatusEnum.DELIVERED);
    billrepository.save(billEntity);

    return convertBillEntityToBillDTO(billEntity);
  }

  @Override
  public BillDTO findBillById(Long id) {
    BillEntity billEntity = billrepository.findById(id).get();
    return convertBillEntityToBillDTO(billEntity);
  }

  private BillDTO convertBillEntityToBillDTO(BillEntity billEntity){
    BillDTO billDTO = new BillDTO();

    UserDTO userDTO = new UserDTO();
    userDTO.setId(billEntity.getUserEntity().getId());
    userDTO.setName(billEntity.getUserEntity().getName());
    userDTO.setPhoneNumber(billEntity.getUserEntity().getPhoneNumber());

    List<Food_On_Bill_DTO> food_on_bill_dtos = new ArrayList<>();
    for (BillFoodEntity bf : billEntity.getListFoods()){
      // map two entity food and billFood become one dto
      Food_On_Bill_DTO food_on_bill_dto = new Food_On_Bill_DTO();
      food_on_bill_dto.setName(bf.getFoodEntity().getName());
      food_on_bill_dto.setPrice(bf.getFoodEntity().getPrice());
      food_on_bill_dto.setNumber(bf.getNumber());

      // map that dto to list
      food_on_bill_dtos.add(food_on_bill_dto);
    }

    // set all fields bill dto and return it
    billDTO.setListFoods(food_on_bill_dtos);
    billDTO.setId(billEntity.getId());
    billDTO.setTotal(billEntity.getTotal());
    billDTO.setStatus(billEntity.getStatus().getName());
    billDTO.setTimeOrder(billEntity.getCreatedAt());
    billDTO.setId(billEntity.getId());
    billDTO.setTimeOrder(billEntity.getCreatedAt());
    billDTO.setStatus(billEntity.getStatus().getName());
    billDTO.setTotal(billEntity.getTotal());
    billDTO.setUser(userDTO);

    return billDTO;
  }

  @Override
  public List<DashboardBillEntity> findByDate(ZonedDateTime from,ZonedDateTime to) {
    return dashBoardBillRepository.getByIdUser(from, to);
  }

  @Override
  public List<BillDTO> findAllBill() {
    List<BillDTO> allBills = new ArrayList<>();

    List<BillEntity> billEntities = billrepository.findAll();

    for (BillEntity b : billEntities){
      allBills.add(findBillById(b.getId()));
    }

    return allBills;
  }

  private void preOrderDTO(OrderDTO orderDTO) {
    if (orderDTO.getListFood() == null) {
      throw new NullException("'listFood' is null", orderDTO);
    }
    if (orderDTO.getListFood().isEmpty()) {
      throw new NullException("'listFood' is empty", orderDTO);
    }
  }


}
