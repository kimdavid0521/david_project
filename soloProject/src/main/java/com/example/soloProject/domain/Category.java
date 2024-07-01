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
public class Category extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "category")
    private List<PostCategory> postCategories = new ArrayList<>();
}
