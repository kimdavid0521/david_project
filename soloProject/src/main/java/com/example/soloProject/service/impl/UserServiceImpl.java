package com.example.soloProject.service.impl;

import com.example.soloProject.converter.UserConverter;
import com.example.soloProject.domain.User;
import com.example.soloProject.dto.UserRequestDTO;
import com.example.soloProject.repository.UserRepository;
import com.example.soloProject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public User createUser(UserRequestDTO.JoinDTO joinDTO) {
        User user = UserConverter.toUser(joinDTO);
        return userRepository.save(user);
    }
}
