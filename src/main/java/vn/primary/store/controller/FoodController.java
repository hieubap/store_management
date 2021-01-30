package vn.primary.store.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.primary.common.controller.BaseController;
import vn.primary.store.dto.FoodDTO;
import vn.primary.store.service.FoodService;

@RestController
@RequestMapping(value = "/food")
public class FoodController extends BaseController<FoodDTO, FoodService> {
  @Autowired
  private FoodService foodService;

  @Override
  protected FoodService getService() {
    return foodService;
  }

  @GetMapping(value = "/test")
  public Map<?,?>food() {
    Map<String,String> map = new HashMap<>();
    map.put("name","bread");
    map.put("price","5000");
    return map;
  }
}
