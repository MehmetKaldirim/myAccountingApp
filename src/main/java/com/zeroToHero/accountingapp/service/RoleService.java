package com.zeroToHero.accountingapp.service;

import com.zeroToHero.accountingapp.dto.RoleDTO;

import java.util.List;

public interface RoleService {
    List<RoleDTO> listAllRoles();
    RoleDTO findById(Long Id);
}