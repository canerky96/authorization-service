package com.kaya.auth.authserver.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class PermissionUpdateDTO {

  @NotEmpty(message = "Name cannot be empty")
  private String name;
}
