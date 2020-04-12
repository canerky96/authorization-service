package com.kaya.auth.authserver.controller;

import com.kaya.auth.authserver.dto.PermissionCreateDTO;
import com.kaya.auth.authserver.dto.PermissionResponseDTO;
import com.kaya.auth.authserver.service.impl.PermissionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
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
  public List<PermissionResponseDTO> getAll() {
    return permissionService.getAll();
  }

  @GetMapping("{code}")
  public PermissionResponseDTO get(@PathVariable("code") String code) {
    return permissionService.get(code);
  }

  @PostMapping
  public PermissionResponseDTO create(@RequestBody @Valid PermissionCreateDTO createDTO) {
    return permissionService.create(createDTO);
  }
}
