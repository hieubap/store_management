package vn.primary.store.enums;

import vn.primary.common.enums.IEnum;

public enum OrderStatusEnum implements IEnum {
  ORDER((short) 0),
  DELIVERED((short) 1);

  private Short value;

  OrderStatusEnum(Short value) {
    this.value = value;
  }

  @Override
  public Short getValue() {
    return value;
  }

  @Override
  public String getName() {
    switch (value){
      case 0: return "ORDER";
      case 1: return "DELIVERED";
    }
    return null;
  }

}
