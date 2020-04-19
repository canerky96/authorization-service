package com.kaya.auth.authserver.user.repository;

import com.kaya.auth.authserver.user.entity.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AuthUser, String> {

  Optional<AuthUser> findByUsername(String username);
}
