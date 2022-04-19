package com.sjy.it.car.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * DTO对象
 * @author dyit
 */
@Data
@NoArgsConstructor
public class HttpResp {

    private int id;
    private String msg;
    private Object results;
    private LocalDateTime time;

    public HttpResp(int id, String msg, LocalDateTime time) {
        this.id = id;
        this.msg = msg;
        this.time = time;
    }

    public HttpResp(int id, String msg, Object results, LocalDateTime time) {
        this.id = id;
        this.msg = msg;
        this.results = results;
        this.time = time;
    }
}
