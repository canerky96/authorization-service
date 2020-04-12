package com.kaya.auth.authserver.service;

import com.kaya.auth.authserver.dto.PermissionCreateDTO;
import com.kaya.auth.authserver.dto.PermissionResponseDTO;
import com.kaya.auth.authserver.entity.Permission;
import com.kaya.auth.authserver.exception.PermissionNotFoundException;
import com.kaya.auth.authserver.repository.PermissionRepository;
import com.kaya.auth.authserver.service.impl.PermissionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PermissionServiceImpl implements PermissionService {

  PermissionRepository permissionRepository;

  @Override
  public List<PermissionResponseDTO> getAll() {
    return permissionRepository.findAll().stream()
        .map(PermissionResponseDTO::new)
        .collect(Collectors.toList());
  }

  @Override
  public PermissionResponseDTO get(String code) {

    return new PermissionResponseDTO(
        permissionRepository
            .findByCode(code)
            .orElseThrow(() -> new PermissionNotFoundException(code)));
  }

  @Override
  public PermissionResponseDTO create(PermissionCreateDTO createDTO) {
    Permission permission = new Permission(createDTO);
    permission = permissionRepository.save(permission);
    return new PermissionResponseDTO(permission);
  }
}
