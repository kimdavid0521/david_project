package com.example.soloProject.service.impl;

import com.example.soloProject.apiPayload.code.status.ErrorStatus;
import com.example.soloProject.apiPayload.exception.handler.PostHandler;
import com.example.soloProject.apiPayload.exception.handler.UserHandler;
import com.example.soloProject.converter.PostConverter;
import com.example.soloProject.domain.Post;
import com.example.soloProject.domain.User;
import com.example.soloProject.dto.PostRequestDTO;
import com.example.soloProject.repository.PostRepository;
import com.example.soloProject.repository.UserRepository;
import com.example.soloProject.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;


    @Override
    public Post createPost(PostRequestDTO.UploadPostDTO uploadPostDTO, Long userId) {
        Post post = PostConverter.toPost(uploadPostDTO);
        User user = userRepository.findById(userId).orElseThrow(() -> new UserHandler(ErrorStatus._USER_NOT_FOUND));
        post.setUser(user); //아까 설정해준 연관관계 편의 메서드 사용하여서 유저 설정
        postRepository.save(post);
        return post;
    }

    //user로 post 조회
    @Override
    @Transactional(readOnly = true)
    public List<Post> readPostByUsers(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserHandler(ErrorStatus._USER_NOT_FOUND));
        return postRepository.findAllByUser(user);
    }


    //post 단건 조회
    @Override
    @Transactional(readOnly = true)
    public Post previewPost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new PostHandler(ErrorStatus._POST_NOT_FOUND));
        return post;
    }

    //post 전체조회
    @Override
    @Transactional(readOnly = true)
    public List<Post> previewPostList() {
        return postRepository.findAll();
    }

    //post delete
    @Override
    public void deletePost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new PostHandler(ErrorStatus._POST_NOT_FOUND));
        postRepository.delete(post); //delete는 그냥 리턴값 없이 삭제
    }

    @Override
    public Post updatePost(PostRequestDTO.UpdatePostDTO updatePostDTO, Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new PostHandler(ErrorStatus._POST_NOT_FOUND));
        post.update(updatePostDTO.getTitle(), updatePostDTO.getContent());
        return post;
    }

}
