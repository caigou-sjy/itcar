package com.sjy.it.user.enmus;

import com.sjy.it.enums.Constants;

public enum PrivsEnmus {

    /**
     * 权限
     */
    STAFF(2, "员工管理"),
    ACTIVITY(3,"活动管理"),
    CAR(5,"车辆管理"),
    ;
    private int code;
    private String name;

    PrivsEnmus(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    static public Constants codeOf(int code) {
        for (Constants l : Constants.values()) {
            if (l.getCode() == code) {
                return l;
            }
        }
        return null;
    }

}
