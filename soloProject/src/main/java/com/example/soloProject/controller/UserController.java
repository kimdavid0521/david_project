package com.example.soloProject.controller;

import com.example.soloProject.apiPayload.BaseResponse;
import com.example.soloProject.converter.UserConverter;
import com.example.soloProject.domain.User;
import com.example.soloProject.dto.UserRequestDTO;
import com.example.soloProject.dto.UserResponseDTO;
import com.example.soloProject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    //유저 등록
    @PostMapping("/users")
    public BaseResponse<UserResponseDTO.JoinResultDTO> createUser(@RequestBody UserRequestDTO.JoinDTO joinDTO) {
        User user = userService.createUser(joinDTO);
        return BaseResponse.onSuccess(UserConverter.toJoinResultDTO(user)); // toJoinResultDTO는 userConverter에서 아까 리턴해주려고 했던 joinResultDTO로 만들어주는 메서드
    }

    //유저 단건 조회
    @GetMapping("/{userId}")
    public BaseResponse<UserResponseDTO.UserPreviewDTO> readUser(@PathVariable Long userId) {
        User user = userService.readUser(userId);
        return BaseResponse.onSuccess(UserConverter.toPreviewResultDTO(user));
        // 마찬가지로 user객체를 찾아서 원하는 통일된 응답으로 보내주기 위해 baseresponse에 담아서 userconveter에서 만든 형식으로 보내주는 메서드를 사용하여 응답
    }

    //유저 전체 조회
    @GetMapping("/users")
    public BaseResponse<UserResponseDTO.UserPreviewListDTO> readAllUser() {
        List<User> userList = userService.readAllUsers();
        return BaseResponse.onSuccess(UserConverter.toPreviewResultListDTO(userList));
    }

    //유저 delete
    @DeleteMapping("/users/{userId}")
    public BaseResponse<String> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return BaseResponse.onSuccess("삭제 되었습니다.");
    }

}
