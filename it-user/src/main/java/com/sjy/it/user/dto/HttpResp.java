package com.sjy.it.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class HttpResp {
    private Integer code;
    private String msg;
    private Object results;
    private Date date;
}
