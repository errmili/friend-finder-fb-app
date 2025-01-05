package com.user.management.service;

import javax.transaction.SystemException;

import com.user.management.model.dto.auth.UserDto;
import java.util.Map;

public interface UserService {
    UserDto create(Map<String, Object> params) throws SystemException;
}
