package com.kaya.auth.authserver.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AuthUser extends BaseEntity {

  private static final long serialVersionUID = 5426856794243258850L;
  private String password;
  private String username;
  private Boolean isAccountNonExpired;
  private Boolean isAccountNonLocked;
  private Boolean isCredentialsNonExpired;
  private Boolean isEnabled;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "role_user",
      joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
      inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
  private List<Role> roles;

  public AuthUser(AuthUser user) {
    this.password = user.getPassword();
    this.username = user.getUsername();
    this.isAccountNonExpired = user.getIsAccountNonExpired();
    this.isAccountNonLocked = user.getIsAccountNonLocked();
    this.isCredentialsNonExpired = user.getIsCredentialsNonExpired();
    this.isEnabled = user.getIsEnabled();
    this.roles = user.getRoles();
  }
}
