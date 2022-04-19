package com.sjy.it.car.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.Date;

/**
 * DTO对象
 * @author dyit
 */
@AllArgsConstructor
@NoArgsConstructor
@Data

public class HttpResp {
    private Integer code;
    private String msg;
    private Object results;
    private Date date;
}
