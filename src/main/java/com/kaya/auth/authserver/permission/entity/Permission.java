package com.kaya.auth.authserver.permission.entity;

import com.kaya.auth.authserver.permission.dto.PermissionCreateDTO;
import com.kaya.auth.authserver.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Permission extends BaseEntity {

  private static final long serialVersionUID = -7274223417883492920L;

  public Permission(PermissionCreateDTO createDTO) {
    this.code = createDTO.getCode();
    this.name = createDTO.getName();
  }

  @NotNull private String code;

  @NotNull private String name;
}
