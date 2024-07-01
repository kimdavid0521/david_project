package com.example.soloProject.converter;

import com.example.soloProject.domain.User;
import com.example.soloProject.dto.UserRequestDTO;

public class UserConverter {  //JoinDTO를 받아서 user을 만드는 메서드 작성

    public static User toUser(UserRequestDTO.JoinDTO joinDTO) {
        return User.builder()
                .name(joinDTO.getName())
                .build();
    }
}
