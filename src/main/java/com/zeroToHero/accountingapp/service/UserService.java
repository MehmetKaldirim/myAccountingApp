package com.zeroToHero.accountingapp.service;

import com.zeroToHero.accountingapp.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> listAllUsers();

    void save(UserDTO dto);

    UserDTO update(UserDTO dto);

    void delete(String username);

    UserDTO findById(Long id);
}
