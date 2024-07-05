package com.example.soloProject.domain;

import com.example.soloProject.domain.common.BaseEntity;
import com.example.soloProject.domain.mapping.PostCategory;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    private String title;

    private String content;

    //private boolean isSecret;

    //유저 엔티티랑 다대일 매핑
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "post")
    private List<PostCategory> postCategories = new ArrayList<>();

    @OneToMany(mappedBy = "post")
    private List<Reply> replies = new ArrayList<>();

}
