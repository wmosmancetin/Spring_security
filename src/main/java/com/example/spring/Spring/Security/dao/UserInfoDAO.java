package com.example.spring.Spring.Security.dao;

import com.example.spring.Spring.Security.entity.UserInfo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserInfoDAO implements IUserInfoDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public UserInfo getActiveUser(String userName) {
        UserInfo activeUserInfo = new UserInfo();
        short enabled = 1;
        List<?> list = entityManager.createQuery("SELECT u FROM UserInfo u WHERE userName=:userName")
                .setParameter("userName" , userName).getResultList();
        if (!list.isEmpty()) {
            activeUserInfo = (UserInfo) list.get(0);
        }
        return activeUserInfo;
    }

}
