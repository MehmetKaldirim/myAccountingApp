package com.zeroToHero.accountingapp.service.impl;

import com.zeroToHero.accountingapp.dto.UserDTO;
import com.zeroToHero.accountingapp.entity.User;
import com.zeroToHero.accountingapp.enums.UserStatus;
import com.zeroToHero.accountingapp.mapper.MapperUtil;
import com.zeroToHero.accountingapp.repository.UserRepository;
import com.zeroToHero.accountingapp.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final MapperUtil mapperUtil;

    public UserServiceImpl(UserRepository userRepository, MapperUtil mapperUtil) {
        this.userRepository = userRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<UserDTO> listAllUsers() {
        return userRepository.findAll().stream().map(user->mapperUtil.convert(user,new UserDTO())).collect(Collectors.toList());
    }



    @Override
    public void save(UserDTO dto) {

        if (dto.getUserStatus().equals("ACTIVE")){
            dto.setUserStatus(UserStatus.ACTIVE);
        } else {
            dto.setUserStatus(UserStatus.INACTIVE);
        }

        userRepository.save(mapperUtil.convert(dto,new User()));
    }

    @Override
    public UserDTO update(UserDTO dto) {
        return null;
    }



    @Override
    public void delete(String username) {

    }

    @Override
    public UserDTO findById(Long id) {
        return mapperUtil.convert(userRepository.findById(id).get(),new UserDTO());
    }


}
