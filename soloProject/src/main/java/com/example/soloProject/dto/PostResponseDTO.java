package com.example.soloProject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public class PostResponseDTO {

    //업로드 dto
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class uploadResultDTO {
        private Long postId;
        private LocalDateTime createAt;
    }

    //게시글 단건 조회
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class postPreviewDTO {
        private String title;
        private String content;
        private LocalDateTime createAt;
        private LocalDateTime updateAt;
    }

    //게시글 전체 조회
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class postPreviewListDTO {
        List<postPreviewDTO> postPreviewDTOList;
    }
}
