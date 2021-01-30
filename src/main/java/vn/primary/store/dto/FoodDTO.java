package vn.primary.store.dto;

import lombok.ToString;
import vn.primary.common.dto.BaseDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class FoodDTO extends BaseDTO {
    private String name;
    private Long price;
}
