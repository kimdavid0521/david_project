package com.example.soloProject.controller;

import com.example.soloProject.apiPayload.BaseResponse;
import com.example.soloProject.converter.UserConverter;
import com.example.soloProject.domain.User;
import com.example.soloProject.dto.UserRequestDTO;
import com.example.soloProject.dto.UserResponseDTO;
import com.example.soloProject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @PostMapping("/api/v1/users")
    public BaseResponse<UserResponseDTO.JoinResultDTO> createUser(@RequestBody UserRequestDTO.JoinDTO joinDTO) {
        User user = userService.createUser(joinDTO);
        return BaseResponse.onSuccess(UserConverter.);
    }


}
