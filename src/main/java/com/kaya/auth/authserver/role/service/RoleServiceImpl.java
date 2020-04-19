package com.kaya.auth.authserver.role.service;

import com.kaya.auth.authserver.role.dto.RoleQueryDTO;
import com.kaya.auth.authserver.role.dto.RoleResponseDTO;
import com.kaya.auth.authserver.role.entity.Role;
import com.kaya.auth.authserver.role.repository.RoleRepository;
import com.kaya.auth.authserver.role.spec.RoleSpecification;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

  private RoleRepository roleRepository;

  @Override
  public List<RoleResponseDTO> query(RoleQueryDTO queryDTO) {

    List<Role> roles = roleRepository.findAll(new RoleSpecification(queryDTO));
    return roles.stream().map(RoleResponseDTO::new).collect(Collectors.toList());
  }
}
