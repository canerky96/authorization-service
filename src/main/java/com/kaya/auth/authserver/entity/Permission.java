package com.kaya.auth.authserver.entity;

import com.kaya.auth.authserver.dto.PermissionCreateDTO;
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

  public Permission(PermissionCreateDTO createDTO) {
    this.code = createDTO.getCode();
    this.name = createDTO.getName();
  }

  @NotNull private String code;

  @NotNull private String name;
}
