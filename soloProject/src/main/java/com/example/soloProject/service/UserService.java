package com.example.soloProject.service;

import com.example.soloProject.domain.User;
import com.example.soloProject.dto.UserRequestDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {

    //유저 가입
    User createUser(UserRequestDTO.JoinDTO joinDTO);

    //유저 단건 조회
    User readUser(Long userId);

    //유저 전체 조회 service
    List<User> readAllUsers();

    //유저 delete
    void deleteUser(Long userId);

    //유저 업데이트
    User updateUser(UserRequestDTO.UpdateUserDTO updateUserDTO, Long userId);
}
