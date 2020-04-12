package com.kaya.auth.authserver.exception;

public class PermissionNotFoundException extends RuntimeException {
  public PermissionNotFoundException(String code) {
    super("Permission not found with code: " + code);
  }
}
