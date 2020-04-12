package com.kaya.auth.authserver.controller;

import com.kaya.auth.authserver.dto.PermissionCreateDTO;
import com.kaya.auth.authserver.dto.PermissionQueryDTO;
import com.kaya.auth.authserver.dto.PermissionResponseDTO;
import com.kaya.auth.authserver.dto.PermissionUpdateDTO;
import com.kaya.auth.authserver.service.impl.PermissionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("permission")
@AllArgsConstructor
public class PermissionController {

  private PermissionService permissionService;

  @GetMapping
  public List<PermissionResponseDTO> query(PermissionQueryDTO queryDTO) {
    return permissionService.query(queryDTO);
  }

  @PostMapping
  public PermissionResponseDTO create(@RequestBody @Valid PermissionCreateDTO createDTO) {
    return permissionService.create(createDTO);
  }

  @PatchMapping("{code}")
  public PermissionResponseDTO update(
      @PathVariable("code") String code,
      @RequestBody @Valid PermissionUpdateDTO permissionUpdateDTO) {
    return permissionService.update(code, permissionUpdateDTO);
  }
}
