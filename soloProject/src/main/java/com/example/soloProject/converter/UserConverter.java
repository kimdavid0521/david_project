package com.example.soloProject.converter;

import com.example.soloProject.domain.User;
import com.example.soloProject.dto.UserRequestDTO;
import com.example.soloProject.dto.UserResponseDTO;

import java.util.List;

public class UserConverter {  //JoinDTO를 받아서 user을 만드는 메서드 작성

    //유저 변환
    public static User toUser(UserRequestDTO.JoinDTO joinDTO) {
        return User.builder()
                .name(joinDTO.getName())
                .build();
    }

    //유저 가입 응답
    public static UserResponseDTO.JoinResultDTO toJoinResultDTO(User user) {
        return UserResponseDTO.JoinResultDTO.builder()
                .userId(user.getId())
                .createAt(user.getCreateAt())
                .build();
    }

    //유저 단건 조회
    public static UserResponseDTO.UserPreviewDTO toPreviewResultDTO(User user) {
        return UserResponseDTO.UserPreviewDTO.builder()
                .userId(user.getId())
                .name(user.getName())
                .createAt(user.getCreateAt())
                .updateAt(user.getUpdateAt())
                .build();
    }

    //유저 전체 조회
    public static UserResponseDTO.UserPreviewListDTO toPreviewResultListDTO(List<User> userList) {
        List<UserResponseDTO.UserPreviewDTO> userPreviewDTOList = userList.stream().map(UserConverter::toPreviewResultDTO).toList();
        return UserResponseDTO.UserPreviewListDTO.builder()
                .userPreviewDTOList(userPreviewDTOList)
                .build();
    }

}
