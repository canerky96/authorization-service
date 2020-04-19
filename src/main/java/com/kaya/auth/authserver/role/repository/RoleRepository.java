package com.kaya.auth.authserver.role.repository;

import com.kaya.auth.authserver.role.entity.Role;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

  List<Role> findAll(Specification<Role> specification);
}
