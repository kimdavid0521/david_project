package com.example.soloProject.dto;

import lombok.Getter;

public class PostRequestDTO {

    @Getter
    public static class UploadPostDTO{
        private String title;

        private String content;

        private boolean isSecrete;
    }
}
