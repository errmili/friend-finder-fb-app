package com.user.management.repository.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.management.model.userrole.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

}