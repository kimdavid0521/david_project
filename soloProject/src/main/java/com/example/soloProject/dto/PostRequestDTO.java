package com.example.soloProject.dto;

import lombok.Getter;

public class PostRequestDTO {

    //포스트 업로드 dto
    @Getter
    public static class UploadPostDTO{
        private String title;

        private String content;

        private boolean isSecrete;
    }

    //포스트 업데이트 dto
    @Getter
    public static class UpdatePostDTO {
        private String title;
        private String content;
    }

}
