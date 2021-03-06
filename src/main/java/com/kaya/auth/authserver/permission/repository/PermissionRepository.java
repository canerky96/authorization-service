package com.kaya.auth.authserver.permission.repository;

import com.kaya.auth.authserver.permission.entity.Permission;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, String> {

  List<Permission> findAll(Specification<Permission> specification);

  Optional<Permission> findByCode(String code);
}
