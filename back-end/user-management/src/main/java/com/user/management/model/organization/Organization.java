package com.user.management.model.organization;

import lombok.*;

import javax.persistence.*;

import com.spring.commonlib.model.enums.Scope;
import com.user.management.model.organizationrole.OrganizationRole;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.spring.commonlib.model.BaseEntity;

@Getter
@Setter
@Entity
@Table(name = "organization")
public class Organization extends BaseEntity {
    @Column(name = "reference_id")
    private String referenceId;
    @Column(name = "organization_name")
    private String organizationName;
    @Column(name = "password")
    private String password;

    @Column(name = "scope")
    @Enumerated(EnumType.STRING)
    private Scope scope;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "organization")
    //private List<OrganizationRole> roles = new ArrayList<>();
    private Set<OrganizationRole> roles = new HashSet();
    public Organization(String referenceId, String organizationName, String password, Scope scope) {
        this.referenceId = referenceId;
        this.organizationName = organizationName;
        this.password = password;
        this.scope = scope;
    }
}