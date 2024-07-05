package com.example.soloProject.service;

import com.example.soloProject.domain.Post;
import com.example.soloProject.dto.PostRequestDTO;

import java.util.List;

public interface PostService {

    Post createPost(PostRequestDTO.UploadPostDTO uploadPostDTO);

    //post 단건 조회
    Post previewPost(Long postId);

    //post 전체조회
    List<Post> previewPostList();

    //post delete
    void deletePost(Long postId);

    //post update
    Post updatePost(PostRequestDTO.UpdatePostDTO updatePostDTO, Long postId);
}
