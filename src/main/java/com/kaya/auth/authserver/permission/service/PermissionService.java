package com.kaya.auth.authserver.permission.service;

import com.kaya.auth.authserver.permission.dto.PermissionCreateDTO;
import com.kaya.auth.authserver.permission.dto.PermissionQueryDTO;
import com.kaya.auth.authserver.permission.dto.PermissionResponseDTO;
import com.kaya.auth.authserver.permission.dto.PermissionUpdateDTO;

import java.util.List;

public interface PermissionService {

  List<PermissionResponseDTO> query(PermissionQueryDTO queryDTO);

  PermissionResponseDTO create(PermissionCreateDTO createDTO);

  PermissionResponseDTO update(String code, PermissionUpdateDTO permissionUpdateDTO);
}
