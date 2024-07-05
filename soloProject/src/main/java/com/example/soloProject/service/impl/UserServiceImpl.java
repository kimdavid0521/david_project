package com.example.soloProject.service.impl;

import com.example.soloProject.apiPayload.code.status.ErrorStatus;
import com.example.soloProject.apiPayload.exception.handler.UserHandler;
import com.example.soloProject.converter.UserConverter;
import com.example.soloProject.domain.User;
import com.example.soloProject.dto.UserRequestDTO;
import com.example.soloProject.repository.UserRepository;
import com.example.soloProject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    //유저 등록 service
    @Override
    @Transactional
    public User createUser(UserRequestDTO.JoinDTO joinDTO) {
        User user = UserConverter.toUser(joinDTO);
        return userRepository.save(user);
    }

    //유저 단건 조회 service
    @Override
    @Transactional(readOnly = true) //이렇게 하면 성능이 더 좋아짐
    public User readUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserHandler(ErrorStatus._USER_NOT_FOUND)); //유저 에러 응답을 새로 만들어줌 userHandler
        return user;
    }

    //유저 전체 조회 service
    @Override
    @Transactional(readOnly = true)
    public List<User> readAllUsers() {
        return userRepository.findAll();
    }

    //유저 delete
    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserHandler(ErrorStatus._USER_NOT_FOUND));
        userRepository.delete(user);
    }





}
