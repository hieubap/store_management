package vn.primary.store.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Food_On_Bill_DTO {
  private String name;
  private Long price;
  private Long number;
}
