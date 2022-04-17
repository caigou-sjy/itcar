package com.sjy.it.user.service.impl;

import com.sjy.it.user.dao.IRoleDao;
import com.sjy.it.user.entity.Role;
import com.sjy.it.user.exception.AccountNotFoundException;
import com.sjy.it.user.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    IRoleDao ird;

    @Override
    public Role findRoleById(int id) {
        try {
            Optional<Role> role = ird.findById(id);
            return role.get();
        } catch (Exception e) {
            throw new AccountNotFoundException("无效角色Id");
        }
    }
}
