package com.vueadminproject.backend.utils;

import java.security.SecureRandom;
/*
* 此文档用于生成全局唯一的Token值
* 使用了SecureRandom，以后可以使用JWT进行代替
*/
public final class GenerateToken {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();
    private static final int LENGTH = 15;
    public static final String GERNERATE_TOKEN() {
        StringBuilder token = new StringBuilder(LENGTH);
        for (int i = 0; i < LENGTH; i++) {
            int index = SECURE_RANDOM.nextInt(CHARACTERS.length());
            token.append(CHARACTERS.charAt(index));
        }
        return token.toString();
    }
}
