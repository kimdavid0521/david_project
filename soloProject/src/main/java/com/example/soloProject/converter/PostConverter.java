package com.example.soloProject.converter;

import com.example.soloProject.domain.Post;
import com.example.soloProject.dto.PostRequestDTO;
import com.example.soloProject.dto.PostResponseDTO;

import java.util.List;

public class PostConverter {

    public static Post toPost(PostRequestDTO.UploadPostDTO uploadPostDTO) {
        return Post.builder()
                .title(uploadPostDTO.getTitle())
                .content(uploadPostDTO.getContent())
                .isSecret(uploadPostDTO.isSecrete())
                .build();
    }

    public static PostResponseDTO.uploadResultDTO toUploadResultDTO(Post post) {
        return PostResponseDTO.uploadResultDTO.builder()
                .postId(post.getId())
                .createAt(post.getCreateAt())
                .build();
    }

    //게시글 단건 조회
    public static PostResponseDTO.postPreviewDTO toPreviewPostDTO(Post post) {
        return PostResponseDTO.postPreviewDTO.builder()
                .title(post.getTitle())
                .content(post.getContent())
                .isSecrete(post.isSecret())
                .createAt(post.getCreateAt())
                .updateAt(post.getUpdateAt())
                .build();
    }

    //게시글 전체 조회
    public static PostResponseDTO.postPreviewListDTO toPreviewPostListDTO(List<Post> postList) {
        List<PostResponseDTO.postPreviewDTO> postPreviewDTOList = postList.stream().map(PostConverter::toPreviewPostDTO).toList();
        return PostResponseDTO.postPreviewListDTO.builder()
                .postPreviewDTOList(postPreviewDTOList)
                .build();
    }
}
