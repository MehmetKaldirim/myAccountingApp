package com.zeroToHero.accountingapp.service.impl;

import com.zeroToHero.accountingapp.dto.CompanyDTO;
import com.zeroToHero.accountingapp.dto.UserDTO;
import com.zeroToHero.accountingapp.entity.Company;
import com.zeroToHero.accountingapp.entity.Product;
import com.zeroToHero.accountingapp.entity.User;
import com.zeroToHero.accountingapp.entity.common.UserPrincipal;
import com.zeroToHero.accountingapp.enums.UserStatus;
import com.zeroToHero.accountingapp.mapper.MapperUtil;
import com.zeroToHero.accountingapp.repository.UserRepository;
import com.zeroToHero.accountingapp.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final MapperUtil mapperUtil;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, MapperUtil mapperUtil, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.mapperUtil = mapperUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<UserDTO> listAllUsers() {
        List<User> list = userRepository.findAllByCompany(findCompanyByLoggedInUser());

        return list.stream().map(user -> mapperUtil.convert(user, new UserDTO())).collect(Collectors.toList());
    }


    @Override
    public void save(UserDTO dto) {
        dto.setPassWord(passwordEncoder.encode(dto.getPassWord()));
        dto.setEnabled(true);
        userRepository.save(mapperUtil.convert(dto, new User()));
    }

    @Override
    public UserDTO update(UserDTO dto) {

        User user = userRepository.findByEmail(dto.getEmail());
        User convertedUser = mapperUtil.convert(dto, new User());
        //set id to converted object which we found in DB by Email
        convertedUser.setId(user.getId());
        convertedUser.setEnabled(user.getEnabled());
        convertedUser.setPassword(user.getPassword());
        userRepository.save(convertedUser);

        return findByEmail(dto.getEmail());
    }

    @Override
    public void delete(String email) {
        User user = userRepository.findByEmail(email);
        user.setIsDeleted(true);
        userRepository.save(user);
    }

    @Override
    public UserDTO findById(Long id) {
        return mapperUtil.convert(userRepository.findById(id).get(), new UserDTO());
    }

    @Override
    public UserDTO findByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return mapperUtil.convert(user, new UserDTO());
    }



    @Override
    public Company findCompanyByLoggedInUser() {
        final Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Company company = ((UserPrincipal) principal).getCompany();
        return company;
    }

    @Override
    public CompanyDTO findCompanyDTOByLoggedInUser() {
        final Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Company company = ((UserPrincipal) principal).getCompany();
        return mapperUtil.convert(company, new CompanyDTO());
    }

    @Override
    public UserDTO findLoggedInUser() {
        final Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = ((UserPrincipal) principal).getEmail();
        UserDTO userDTO = findByEmail(email);
        return userDTO;
    }

}
