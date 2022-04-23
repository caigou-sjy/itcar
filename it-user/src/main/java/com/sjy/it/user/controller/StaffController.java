package com.sjy.it.user.controller;

import com.sjy.it.user.annotation.StaffAnnotation;
import com.sjy.it.user.entity.User;
import com.sjy.it.user.util.CacheKeyUtil;
import com.sjy.it.user.dto.HttpResp;
import com.sjy.it.user.entity.PR;
import com.sjy.it.user.entity.Role;
import com.sjy.it.user.entity.UserPrivs;
import com.sjy.it.user.exception.AccountNotFoundException;
import com.sjy.it.user.service.IPRService;
import com.sjy.it.user.service.IPrivsService;
import com.sjy.it.user.service.IRoleService;
import com.sjy.it.user.service.IUserService;
import com.sjy.it.user.util.CacheUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Api(tags = "用户模块-员工管理")
@RestController
@RequestMapping("/api/staff")
public class StaffController {

    private final static Logger logger = LoggerFactory.getLogger(StaffController.class);

    @Autowired
    IRoleService irs;

    @Autowired
    IPrivsService ips;

    @Autowired
    IPRService iprs;

    @Autowired
    IUserService ius;

    @ApiOperation(value = "获取员工列表")
    @GetMapping("/getStaffList")
    @StaffAnnotation
    public HttpResp getStaffList(@RequestParam(value = "userId") Integer userId) {
        List<User> staffList = ius.findAll();
        if (staffList != null && !staffList.isEmpty()) {
            return new HttpResp(0, "查询员工列表成功", staffList, new Date());
        } else {
            return new HttpResp(-1, "未查询到，请重试！", null, new Date());
        }
    }

    @ApiOperation(value = "查询员工权限列表")
    @GetMapping("/getPrivsList")
    @StaffAnnotation
    public HttpResp getPrivsList(@RequestParam(value = "userId") Integer userId) {
        List<User> users = ius.findAll();
        List<UserPrivs> userPrivsList = new ArrayList<>();
        try {
            for (User user : users) {
                UserPrivs up = new UserPrivs();
                up.setUserId(user.getId());
                up.setUsername(user.getUsername());
                up.setRoleName(user.getRole().getName());
                List<PR> prs = iprs.findPRSByRoleId(user.getRole().getId());
                //线程不安全但高效
                StringBuilder sb = new StringBuilder();
                for (PR pr : prs) {
                    sb.append(pr.getPrivs().getName());
                    sb.append(" ");
                }
                up.setPrivsString(sb.toString());
                userPrivsList.add(up);
            }
            return new HttpResp(0, "查询员工权限列表成功", userPrivsList, new Date());
        } catch (Exception e) {
            logger.error("StaffController getPrivsList faild, param userId={}", userId);
            return new HttpResp(-1, "查询员工权限列表失败", null, new Date());
        }
    }

    @ApiOperation(value = "修改员工角色")
    @PostMapping("/updateUserPrivs")
    @StaffAnnotation
    public HttpResp updateUserPrivs(@RequestParam(value = "userId") Integer userId,@RequestParam(value = "privsStaffId") String privsStaffId, @RequestParam(value = "privsRoleId") String privsRoleId) {
        int staffId = Integer.valueOf(privsStaffId);
        int roleId = Integer.valueOf(privsRoleId);
        User staff = ius.findUserById(staffId);
        if (staff == null) {
            throw new AccountNotFoundException("无效的员工ID，请核对！");
        }
        Role role = irs.findRoleById(roleId);
        if (role == null) {
            throw new AccountNotFoundException("无效的角色ID，请核对！");
        }
        staff.setRole(role);
        User updateUser = ius.update(staff);

        // ⚠️ 重要：
        //修改权限后要刷新该用户的权限缓存
        String privsKey = CacheKeyUtil.getPrivsKey(staffId,staff.getUsername());
        List<PR> prsByRoleId = iprs.findPRSByRoleId(roleId);
        CacheUtil.updatePrivsCache(staffId,staff.getUsername(),prsByRoleId);
        return new HttpResp(0, "修改员工角色成功", updateUser, new Date());

    }

//    @ApiOperation(value = "修改员工角色")
//    @RequestMapping("/getPrivsForm")
//    @StaffAnnotation
//    public HttpResp getPrivsForm(@RequestParam(value = "userId") Integer userId) {
//        return new HttpResp(0,"",null,new Date());
//    }

}
