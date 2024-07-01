package com.example.soloProject.service;

import com.example.soloProject.domain.User;
import com.example.soloProject.dto.UserRequestDTO;

public interface UserService {

    User createUser(UserRequestDTO.JoinDTO joinDTO);
}
