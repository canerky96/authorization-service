package com.kaya.auth.authserver.service.impl;

import com.kaya.auth.authserver.dto.PermissionCreateDTO;
import com.kaya.auth.authserver.dto.PermissionResponseDTO;

import java.util.List;

public interface PermissionService {
  List<PermissionResponseDTO> getAll();

  PermissionResponseDTO get(String code);

  PermissionResponseDTO create(PermissionCreateDTO createDTO);
}
