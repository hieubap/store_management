package vn.primary.store.converter;

import javax.persistence.Converter;
import vn.primary.common.enums.EnumConverter;
import vn.primary.store.enums.RoleEnum;

@Converter(autoApply = true)
public class RoleConverter extends EnumConverter<RoleEnum> {

}
