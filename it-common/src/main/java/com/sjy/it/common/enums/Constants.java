package com.sjy.it.common.enums;

public enum Constants {

    /**
     * 返回码
     */
    SUCCESS(0, "成功"),
    FAIL(-1, "失败"),
    FindProvincesSuccess(2007, "查询所有省成功"),
    FindCitiesSuccess(2008, "查询所有市成功"),
    FindDistributesSuccess(2009, "查询所有区成功"),
    CreateVcodeSuccess(2010,"产生验证码成功"),

    ;
    private int code;
    private String name;

    Constants(int code, String name) {
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
