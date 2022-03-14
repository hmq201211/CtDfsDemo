package com.example.demo.util;

import com.example.demo.model.AuthUser;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

@Component
public class AuthInfoGenerator {
    final AuthUser authUser;

    public AuthInfoGenerator(AuthUser authUser) {
        this.authUser = authUser;
    }

    public String getAuthTimestamp() {
        return String.valueOf(System.currentTimeMillis());
    }

    public String getAuthUsername() {
        return authUser.getUsername();
    }

    public String getAuthMd5() {
        return DigestUtils.md5Hex(authUser.getPassword() + getAuthTimestamp());
    }
}
