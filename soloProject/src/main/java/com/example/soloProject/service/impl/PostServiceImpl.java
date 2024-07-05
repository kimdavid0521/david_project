package com.example.soloProject.service.impl;

import com.example.soloProject.apiPayload.code.status.ErrorStatus;
import com.example.soloProject.apiPayload.exception.handler.PostHandler;
import com.example.soloProject.converter.PostConverter;
import com.example.soloProject.domain.Post;
import com.example.soloProject.dto.PostRequestDTO;
import com.example.soloProject.repository.PostRepository;
import com.example.soloProject.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public Post createPost(PostRequestDTO.UploadPostDTO uploadPostDTO) {
            Post post = PostConverter.toPost(uploadPostDTO);
            return postRepository.save(post);
    }


    //post 단건 조회
    @Override
    public Post previewPost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new PostHandler(ErrorStatus._POST_NOT_FOUND));
        return post;
    }

    //post 전체조회
    @Override
    public List<Post> previewPostList() {
        return postRepository.findAll();
    }

    //post delete
    @Override
    public void deletePost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new PostHandler(ErrorStatus._POST_NOT_FOUND));
        postRepository.delete(post); //delete는 그냥 리턴값 없이 삭제
    }

}
