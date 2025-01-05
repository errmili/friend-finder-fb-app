package com.user.management.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.user.management.repository.procedure.ProcedureRepository;
import com.user.management.service.ProcedureService;

@Repository
public class ProcedureServiceImpl implements ProcedureService {

    @Autowired
    private ProcedureRepository procedureRepository;

    /**
     * add User To Friend Finder
     * @param userId
     * @param scope
     */
    @Override
    public void addUserToFriendFinder(Long userId, String scope) {
        procedureRepository.addUserToFriendFinder(userId, scope);
    }
}
