package com.kaya.auth.authserver.permission.dto;

import com.kaya.auth.authserver.permission.entity.Permission;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PermissionResponseDTO {

  public PermissionResponseDTO(Permission permission) {
    this.code = permission.getCode();
    this.name = permission.getName();
  }

  private String code;
  private String name;
}
