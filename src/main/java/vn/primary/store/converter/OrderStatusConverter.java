package vn.primary.store.converter;

import javax.persistence.Converter;
import vn.primary.common.enums.EnumConverter;
import vn.primary.store.enums.OrderStatusEnum;

@Converter(autoApply = true)
public class OrderStatusConverter extends EnumConverter<OrderStatusEnum> {
}
