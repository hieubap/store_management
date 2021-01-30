package vn.primary.store.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import vn.primary.common.dto.BaseDTO;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class StoreDTO extends BaseDTO {
    private String name;
    private String address;
    private String phoneNumber;
}
