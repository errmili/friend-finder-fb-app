package com.user.management.service;

import javax.transaction.SystemException;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.user.management.model.dto.auth.OrgDto;
import com.user.management.model.dto.auth.UserDto;

@Service
public interface AuthService {

    /**
     * login with user
     * @param params
     * @return AuthDto
     */
    UserDto authUser(Map<String, Object> params) throws SystemException;
    /**
     * login with organization
     * @param params
     * @return OrgAuthDto
     */
    OrgDto authOrganization(Map<String, Object> params) throws SystemException;

    <T> Optional<T> authByToken(String token);
}
