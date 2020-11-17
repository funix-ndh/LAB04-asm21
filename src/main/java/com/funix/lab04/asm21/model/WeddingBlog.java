package com.funix.lab04.asm21.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeddingBlog {
    @Id
    private Integer id;
    private String title;
    private String postType;
    private String imgUrl;
    private String paragraph;
    private Integer likeCount;
    private Integer commentCount;
    private LocalDate publishedDate;
}

