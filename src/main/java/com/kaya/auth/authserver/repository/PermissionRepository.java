package com.kaya.auth.authserver.repository;

import com.kaya.auth.authserver.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, String> {

  List<Permission> findAll();

  Optional<Permission> findByCode(String code);
}
