package com.sjy.it.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPrivs {
    public Integer userId;
    public String username;
    public String roleName;
    public String privsString;
}
