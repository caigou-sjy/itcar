package com.sjy.it.authority.dao;

import com.sjy.it.authority.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao extends JpaRepository<User,Integer> {
    User findUserByUsernameAndPassword(String username, String password);
}
