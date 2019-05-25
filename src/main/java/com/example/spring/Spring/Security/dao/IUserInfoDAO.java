package com.example.spring.Spring.Security.dao;

import com.example.spring.Spring.Security.entity.UserInfo;

public interface IUserInfoDAO {
    UserInfo getActiveUser(String userName);
}
