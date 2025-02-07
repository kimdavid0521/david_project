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
@RequestMapping("/api/v1")
public class PostController {

    private final PostService postService;


    //게시글 등록 create
    @PostMapping("/users/{userId}/post")
    public BaseResponse<PostResponseDTO.uploadResultDTO> uploadPost(@RequestBody PostRequestDTO.UploadPostDTO uploadPostDTO,
                                                                    @PathVariable Long userId) {
        Post post = postService.createPost(uploadPostDTO, userId);
        return BaseResponse.onSuccess(PostConverter.toUploadResultDTO(post));

    }

    //게시글 아이디로 조회
    @GetMapping("/post/{postId}")
    public BaseResponse<PostResponseDTO.postPreviewDTO> previewPost(@PathVariable Long postId) {
        Post post = postService.previewPost(postId);
        return BaseResponse.onSuccess(PostConverter.toPreviewPostDTO(post));
    }

    //유저 엔티티로 게시글 조회
    @GetMapping("/user/{userId}/post")
    public BaseResponse<PostResponseDTO.postPreviewListDTO> readPostByUser(@PathVariable Long userId) {
        List<Post> posts = postService.readPostByUsers(userId);
        return BaseResponse.onSuccess(PostConverter.toPreviewPostListDTO(posts));
    }

    //게시글 전체 조회
    @GetMapping("/posts")
    public BaseResponse<PostResponseDTO.postPreviewListDTO> previewList() {
        List<Post> postList = postService.previewPostList();
        return BaseResponse.onSuccess(PostConverter.toPreviewPostListDTO(postList));
    }


    //게시글 삭제 delete
    @DeleteMapping("/post/{postId}")
    public BaseResponse<String> deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
        return BaseResponse.onSuccess("삭제 되었습니다.");
    }

    //게시글 업데이트
    @PatchMapping("/post/{postId}")
    public BaseResponse<PostResponseDTO.postPreviewDTO> updatePost(@RequestBody PostRequestDTO.UpdatePostDTO updatePostDTO,
                                                                   @PathVariable Long postId) {
        Post post = postService.updatePost(updatePostDTO, postId);
        return BaseResponse.onSuccess(PostConverter.toPreviewPostDTO(post));
    }

}
