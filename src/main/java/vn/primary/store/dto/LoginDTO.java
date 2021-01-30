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
public class LoginDTO extends BaseDTO {
  private String username;
  private String password;
}
