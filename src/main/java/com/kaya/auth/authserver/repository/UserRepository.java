package com.kaya.auth.authserver.repository;

import com.kaya.auth.authserver.entity.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AuthUser, String> {

  Optional<AuthUser> findByUsername(String username);
}
