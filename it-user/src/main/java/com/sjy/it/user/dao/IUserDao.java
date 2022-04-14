package com.sjy.it.user.dao;

import com.sjy.it.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao extends JpaRepository<User,Integer> {
    User findUserByUsernameAndPassword(String username, String password);
    User findUserByUsername(String username);
}
