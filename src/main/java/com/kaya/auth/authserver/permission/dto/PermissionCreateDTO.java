package com.kaya.auth.authserver.permission.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class PermissionCreateDTO {

  @NotEmpty private String code;
  @NotEmpty private String name;
}
