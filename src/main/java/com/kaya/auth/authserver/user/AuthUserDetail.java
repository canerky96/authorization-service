package com.kaya.auth.authserver.user;

import com.kaya.auth.authserver.user.entity.AuthUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AuthUserDetail extends AuthUser implements UserDetails {

  public AuthUserDetail(AuthUser user) {
    super(user);
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    List<GrantedAuthority> authorities = new ArrayList<>();
    super.getRoles().stream()
        .flatMap(role -> role.getPermissions().stream())
        .forEach(permission -> authorities.add(new SimpleGrantedAuthority(permission.getCode())));
    return authorities;
  }

  @Override
  public String getPassword() {
    return super.getPassword();
  }

  @Override
  public String getUsername() {
    return super.getUsername();
  }

  @Override
  public boolean isAccountNonExpired() {
    return super.getIsAccountNonExpired();
  }

  @Override
  public boolean isAccountNonLocked() {
    return super.getIsAccountNonLocked();
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return super.getIsCredentialsNonExpired();
  }

  @Override
  public boolean isEnabled() {
    return super.getIsEnabled();
  }
}
