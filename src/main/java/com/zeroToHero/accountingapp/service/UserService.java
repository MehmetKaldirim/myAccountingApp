package com.zeroToHero.accountingapp.service;

import com.zeroToHero.accountingapp.dto.CompanyDTO;
import com.zeroToHero.accountingapp.dto.UserDTO;
import com.zeroToHero.accountingapp.entity.Company;

import java.util.List;

public interface UserService {

    List<UserDTO> listAllUsers();

    void save(UserDTO dto);

    UserDTO update(UserDTO dto);

    void delete(String username);

    UserDTO findById(Long id);

    UserDTO findByEmail(String email);

    Company findCompanyByUserName();

    Company findCompanyByLoggedInUser();
}