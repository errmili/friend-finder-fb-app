package com.user.management.repository.organization;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.management.model.organizationrole.OrganizationRole;

@Repository
public interface OrganizationRoleRepository extends JpaRepository<OrganizationRole, Long> {

}
