package com.kaya.auth.authserver.service;

import com.kaya.auth.authserver.entity.AuthUserDetail;
import com.kaya.auth.authserver.entity.AuthUser;
import com.kaya.auth.authserver.exception.UserNotFoundException;
import com.kaya.auth.authserver.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

  UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    AuthUser user =
        userRepository
            .findByUsername(username)
            .orElseThrow(() -> new UserNotFoundException(username));

    AuthUserDetail userDetail = new AuthUserDetail(user);

    new AccountStatusUserDetailsChecker().check(userDetail);

    return userDetail;
  }
}
