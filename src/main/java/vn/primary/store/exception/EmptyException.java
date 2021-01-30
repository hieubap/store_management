package vn.primary.store.exception;

import vn.primary.common.exception.BaseException;

public class EmptyException extends BaseException {
  private static final int ERROR_CODE = 1000;
  public EmptyException(String message, Object data) {
    super(ERROR_CODE, message, data);
  }
}
