package com.zeroToHero.accountingapp.service.impl;

import com.zeroToHero.accountingapp.dto.UserDTO;
import com.zeroToHero.accountingapp.entity.User;
import com.zeroToHero.accountingapp.mapper.MapperUtil;
import com.zeroToHero.accountingapp.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    UserRepository userRepository;

    @Mock
    MapperUtil mapperUtil;

    @Mock
    PasswordEncoder passwordEncoder;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    void deleteByEmail_test(){

        userService.deleteByEmail("employee1@company3.com");
        verify(userRepository).deleteByEmail("employee1@company3.com");
        verify(userRepository,times(2)).deleteByEmail("employee1@company3.com");

    }

    @Test
    void deleteByEmail_testTimes(){

        userService.deleteByEmail("employee1@company3.com");
        verify(userRepository,times(1)).deleteByEmail("employee1@company3.com");

    }

    @Test
    void deleteByEmail_testAtLeastOnce(){

        userService.deleteByEmail("employee1@company3.com");
        verify(userRepository,atLeastOnce()).deleteByEmail("employee1@company3.com");

    }



    @Test
    void findByEmail_test(){

        //Given
        User user = new User();
        UserDTO userDTO = new UserDTO();
        when(userRepository.findByEmail("employee1@company3.com")).thenReturn(user);
        when(mapperUtil.convert(user,userDTO)).thenReturn(userDTO);

        //When
        UserDTO userDTO1= userService.findByEmail("employee1@company3.com");

        //Then
        verify(userRepository).findByEmail("employee1@company3.com");
        verify(mapperUtil).convert(user,userDTO);

        assertNotNull(userDTO1);
    }

    @Test
    void findByEmail_exception_test(){
        when(userRepository.findByEmail("")).thenThrow(new RuntimeException("User not found"));
        Throwable exception = assertThrows(RuntimeException.class, ()->userRepository.findByEmail(""));
        //assertThrows(RuntimeException.class, ()->userRepository.findByEmail("employee1@company3.com"));
        verify(userRepository).findByEmail(anyString());
        assertEquals("User not found",exception.getMessage());
    }

    @Test
    void save_test(){
        UserDTO userDTO = new UserDTO();
        User user = new User();
        when(mapperUtil.convert(userDTO,user)).thenReturn(user);
        when(userRepository.save(user)).thenReturn(user);
        userService.save(userDTO);
        verify(mapperUtil).convert(any(UserDTO.class),any(User.class));
        verify(userRepository).save(user);
    }

    @ParameterizedTest
    @ValueSource(longs = {1L, 2L, 3L, -5L})
    void findById_test(Long id){

        User user = new User();
        UserDTO userDTO = new UserDTO();

        when(userRepository.findById(id)).thenReturn(Optional.of(user));
        when(mapperUtil.convert(user, userDTO)).thenReturn(userDTO);

        userService.findById(id);

        verify(userRepository).findById(id);
        verify(userRepository).findById(anyLong());
        verify(mapperUtil).convert(any(User.class),any(UserDTO.class));
        //verify(userRepository,never()).findById(-5L);

    }

    //Same test bdd style
    @Test
    void findById_bdd_test() {

        //given
        User user = new User();
        UserDTO userDTO = new UserDTO();


        given(userRepository.findById(anyLong())).willReturn(Optional.of(user));
        given(mapperUtil.convert(user,userDTO)).willReturn(userDTO);

        //When
        userService.findById(anyLong());

        //then
        then(userRepository).should().findById(anyLong());
        then(userRepository).should(never()).findById(-5L);


    }

}