package com.kaya.auth.authserver.role.service;

import com.kaya.auth.authserver.role.dto.RoleQueryDTO;
import com.kaya.auth.authserver.role.dto.RoleResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {


    @Override
    public List<RoleResponseDTO> query(RoleQueryDTO queryDTO) {
    return null;
    }
}
