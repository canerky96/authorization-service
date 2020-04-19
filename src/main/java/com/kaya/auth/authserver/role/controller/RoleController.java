package com.kaya.auth.authserver.role.controller;

import com.kaya.auth.authserver.role.dto.RoleQueryDTO;
import com.kaya.auth.authserver.role.dto.RoleResponseDTO;
import com.kaya.auth.authserver.role.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("role")
@RestController
@AllArgsConstructor
public class RoleController {

  RoleService roleService;

  @GetMapping
  List<RoleResponseDTO> query(RoleQueryDTO queryDTO) {
    return roleService.query(queryDTO);
  }
}
