package com.user.management.model.userrole;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

import com.user.management.model.user.User;
import com.user.management.model.role.CompositeKey;
import com.user.management.model.role.Role;

@Setter
@Getter
@Entity
@Table(name = "user_role")
@NoArgsConstructor
public class UserRole implements Serializable {

    @EmbeddedId
    private CompositeKey compositeKey = new CompositeKey();

    @ManyToOne
    @JoinColumn(name = "user_id")
    @MapsId("integrationId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "role_id")
    @MapsId("roleId")
    private Role role;

    public UserRole(User user, Role role) {
        this.user = user;
        this.role = role;
    }
}