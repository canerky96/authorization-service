package com.kaya.auth.authserver.role.service;

import com.kaya.auth.authserver.role.dto.RoleQueryDTO;
import com.kaya.auth.authserver.role.dto.RoleResponseDTO;

import java.util.List;

public interface RoleService {

  List<RoleResponseDTO> query(RoleQueryDTO queryDTO);
}
