package com.spring.friends.model;

import com.spring.friends.enums.Gender;
//import jakarta.persistence.Entity;
import javax.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "User_System")
public class User extends BaseEntity{

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private long id;

    @Column(name = "first_name")
    private  String firstName;

    @Column(name = "last_name")
    private  String lasteName;

    @Column(name = "age")
    private String age;

    @Column(name = "phone")
    private String phone;

    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date date;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    @OneToMany(mappedBy = "user")
    private List<Friend> friends;


}
