package vn.primary.store.dto;

import vn.primary.common.dto.BaseDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO extends BaseDTO {
    private Long id;
    private String name;
    private String phoneNumber;
}
