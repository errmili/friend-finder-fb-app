package com.user.management.model.role;

import lombok.*;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import com.spring.commonlib.model.BaseEntity;
import com.user.management.model.userrole.UserRole;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Setter
@Getter
@Table(name = "role")
public class Role extends BaseEntity {

    @Column(unique = true)
    private String code;// admin
    private String displayName;// Admin

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "role")
    List<UserRole> userRoles = new ArrayList<>();
}
