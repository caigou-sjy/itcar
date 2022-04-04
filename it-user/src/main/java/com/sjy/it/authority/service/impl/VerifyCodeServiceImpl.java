package com.sjy.it.authority.service.impl;

import com.sjy.it.authority.service.IVerifyCodeService;
import com.sjy.it.authority.util.VerifyCodeUtil;
import org.springframework.stereotype.Service;

import java.io.OutputStream;

@Service
public class VerifyCodeServiceImpl implements IVerifyCodeService {
    @Override
    public int getVerifyCode(OutputStream out) {
        return VerifyCodeUtil.ctrat(out);
    }
}
