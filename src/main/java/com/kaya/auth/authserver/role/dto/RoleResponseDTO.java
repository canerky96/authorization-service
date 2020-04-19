package com.kaya.auth.authserver.role.dto;

import com.kaya.auth.authserver.permission.dto.PermissionResponseDTO;
import com.kaya.auth.authserver.role.entity.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class RoleResponseDTO {

  private String code;
  private String name;
  private Set<PermissionResponseDTO> permissions;

  public RoleResponseDTO(Role role) {
    this.code = role.getCode();
    this.name = role.getName();
    this.permissions =
        role.getPermissions().stream().map(PermissionResponseDTO::new).collect(Collectors.toSet());
  }
}
