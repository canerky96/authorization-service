package com.kaya.auth.authserver.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

@Configuration
@AllArgsConstructor
public class AuthorizationServerConfiguration implements AuthorizationServerConfigurer {

  private PasswordEncoder passwordEncoder;
  private DataSource dataSource;
  private AuthenticationManager authenticationManager;

  @Bean
  TokenStore jdbcTokenStore(){
    return new JdbcTokenStore(dataSource);
  }

  @Override
  public void configure(AuthorizationServerSecurityConfigurer securityConfigurer) throws Exception {
    securityConfigurer.checkTokenAccess("isAuthenticated()").tokenKeyAccess("permitAll()");
  }

  @Override
  public void configure(ClientDetailsServiceConfigurer clientConfigurer) throws Exception {
    clientConfigurer.jdbc(dataSource).passwordEncoder(passwordEncoder);
  }

  @Override
  public void configure(AuthorizationServerEndpointsConfigurer endpointsConfigurer)
      throws Exception {
    endpointsConfigurer.tokenStore(jdbcTokenStore());
    endpointsConfigurer.authenticationManager(authenticationManager);
  }
}
