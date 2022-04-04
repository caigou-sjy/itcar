package com.sjy.it.authority.service;

import java.io.OutputStream;

public interface IVerifyCodeService {
    public int getVerifyCode(OutputStream out);
}
