package vn.primary.store.dto;

import java.time.ZonedDateTime;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import vn.primary.common.dto.BaseDTO;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class BillDTO extends BaseDTO {
  private Long id;
  private ZonedDateTime timeOrder;
  private ZonedDateTime timeReceived;
  private UserDTO user;
  private String status;
  private List<Food_On_Bill_DTO> listFoods;
  private Long total;
}