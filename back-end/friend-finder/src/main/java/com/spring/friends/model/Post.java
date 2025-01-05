package com.spring.friends.model;
import com.spring.commonlib.model.BaseEntity;

import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Post")
public class Post extends BaseEntity{

//    private long id;

    @Column(name = "image_path")
    private String image;

    @Column(name = "text")
    private String text;

    @Column(name = "likes")
    private int likes;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
