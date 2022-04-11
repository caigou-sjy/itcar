package com.sjy.it.user.service;

import java.io.OutputStream;

public interface IVerifyCodeService {
    public int getVerifyCode(OutputStream out);
}
