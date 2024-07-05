package com.example.soloProject.repository;

import com.example.soloProject.domain.Post;
import com.example.soloProject.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    //user로 모든 게시글을 찾겠다
    List<Post> findAllByUser(User user);
}
