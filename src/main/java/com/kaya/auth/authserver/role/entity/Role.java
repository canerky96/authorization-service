package com.kaya.auth.authserver.role.entity;

import com.kaya.auth.authserver.entity.BaseEntity;
import com.kaya.auth.authserver.permission.entity.Permission;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
public class Role extends BaseEntity {

  private static final long serialVersionUID = -6050278768130377436L;
  @NotNull private String code;
  @NotNull private String name;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "permission_role",
      joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")},
      inverseJoinColumns = {@JoinColumn(name = "permission_id", referencedColumnName = "id")})
  private List<Permission> permissions;
}
