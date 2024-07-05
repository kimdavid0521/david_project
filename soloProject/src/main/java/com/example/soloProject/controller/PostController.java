package com.example.soloProject.controller;

import com.example.soloProject.apiPayload.BaseResponse;
import com.example.soloProject.converter.PostConverter;
import com.example.soloProject.domain.Post;
import com.example.soloProject.dto.PostRequestDTO;
import com.example.soloProject.dto.PostResponseDTO;
import com.example.soloProject.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    //게시글 등록 create
    @PostMapping("api/v1/post")
    public BaseResponse<PostResponseDTO.uploadResultDTO> uploadPost(@RequestBody PostRequestDTO.UploadPostDTO uploadPostDTO) {
        Post post = postService.createPost(uploadPostDTO);
        return BaseResponse.onSuccess(PostConverter.toUploadResultDTO(post));
    }

    //게시글 아이디로 조회
    @GetMapping("/api/v1/post/{postId}")
    public BaseResponse<PostResponseDTO.postPreviewDTO> previewPost(@PathVariable Long postId) {
        Post post = postService.previewPost(postId);
        return BaseResponse.onSuccess(PostConverter.toPreviewPostDTO(post));
    }

    //게시글 전체 조회
    @GetMapping("/api/v1/posts")
    public BaseResponse<PostResponseDTO.postPreviewListDTO> previewListDTO() {
        List<Post> postList = postService.previewPostList();
        return BaseResponse.onSuccess(PostConverter.toPreviewPostListDTO(postList));
    }


    //게시글 삭제 delete
    @DeleteMapping("/api/v1/post/{postId}")
    public void deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
    }
}
