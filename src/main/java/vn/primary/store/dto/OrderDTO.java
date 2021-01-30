package vn.primary.store.dto;

import java.util.Map;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import vn.primary.common.dto.BaseDTO;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class OrderDTO extends BaseDTO {
  private Map<Long,Long> listFood;
  private Long total;
}
