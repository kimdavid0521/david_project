package com.example.soloProject.domain;

import com.example.soloProject.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    //post 게시글이랑 일대다 매핑
    @OneToMany(mappedBy = "user")
    @Builder.Default
    private List<Post> posts = new ArrayList<>();
}
