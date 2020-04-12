package com.kaya.auth.authserver.service;

import com.kaya.auth.authserver.dto.PermissionCreateDTO;
import com.kaya.auth.authserver.dto.PermissionQueryDTO;
import com.kaya.auth.authserver.dto.PermissionResponseDTO;
import com.kaya.auth.authserver.dto.PermissionUpdateDTO;
import com.kaya.auth.authserver.entity.Permission;
import com.kaya.auth.authserver.exception.PermissionNotFoundException;
import com.kaya.auth.authserver.repository.PermissionRepository;
import com.kaya.auth.authserver.service.impl.PermissionService;
import com.kaya.auth.authserver.specification.PermissionSpecification;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PermissionServiceImpl implements PermissionService {

  PermissionRepository permissionRepository;

  @Override
  public List<PermissionResponseDTO> query(PermissionQueryDTO queryDTO) {

    List<Permission> permissions =
        permissionRepository.findAll(new PermissionSpecification(queryDTO));

    return permissions.stream().map(PermissionResponseDTO::new).collect(Collectors.toList());
  }

  @Override
  public PermissionResponseDTO create(PermissionCreateDTO createDTO) {
    Permission permission = new Permission(createDTO);
    permission = permissionRepository.save(permission);
    return new PermissionResponseDTO(permission);
  }

  @Override
  public PermissionResponseDTO update(String code, PermissionUpdateDTO permissionUpdateDTO) {

    Permission permission =
        permissionRepository
            .findByCode(code)
            .orElseThrow(() -> new PermissionNotFoundException(code));

    permission.setName(permissionUpdateDTO.getName());

    permission = permissionRepository.save(permission);

    return new PermissionResponseDTO(permission);
  }
}
