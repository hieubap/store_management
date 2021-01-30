package vn.primary.store.exception;

import vn.primary.common.exception.BaseException;

public class NullException extends BaseException {
  private static final int ERROR_CODE = 1000;
  public NullException(String message, Object data) {
    super(ERROR_CODE, message, data);
  }
}
