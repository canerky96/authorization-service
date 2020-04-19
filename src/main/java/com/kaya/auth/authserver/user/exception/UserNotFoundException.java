package com.kaya.auth.authserver.user.exception;

public class UserNotFoundException extends RuntimeException {
  public UserNotFoundException(String username) {
    super("User not found with username: " + username);
  }
}
