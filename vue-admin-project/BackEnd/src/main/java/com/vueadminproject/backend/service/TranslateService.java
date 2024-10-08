package com.vueadminproject.backend.service;

import com.vueadminproject.backend.utils.AuthV3Util;
import com.vueadminproject.backend.utils.HttpUtil;
import com.vueadminproject.backend.utils.Result;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

@Service
public class TranslateService {
    private static final String APP_KEY ="07b2f092ee858b7d";     // 您的应用ID
    private static final String APP_SECRET = "4E7LXAaZfAjAy4W8Vqhd5BO5ZTip4Nt0";  // 您的应用密钥
    private static Map<String, String[]> createRequestParams(String q,String from,String to) {
        /*
         * note: 将下列变量替换为需要请求的参数
         * 取值参考文档: https://ai.youdao.com/DOCSIRMA/html/%E8%87%AA%E7%84%B6%E8%AF%AD%E8%A8%80%E7%BF%BB%E8%AF%91/API%E6%96%87%E6%A1%A3/%E6%96%87%E6%9C%AC%E7%BF%BB%E8%AF%91%E6%9C%8D%E5%8A%A1/%E6%96%87%E6%9C%AC%E7%BF%BB%E8%AF%91%E6%9C%8D%E5%8A%A1-API%E6%96%87%E6%A1%A3.html
         */
//        String q = "您好";
//        String from = "zh-CHS";
//        String to = "en";
        return new HashMap<String, String[]>() {{
            put("q", new String[]{q});
            put("from", new String[]{from});
            put("to", new String[]{to});
        }};
    }
    public Result<String> translate(String q, String from, String to) throws NoSuchAlgorithmException {
        // 添加请求参数
        Map<String, String[]> params = createRequestParams(q,from,to);
        // 添加鉴权相关参数
        AuthV3Util.addAuthParams(APP_KEY, APP_SECRET, params);
        // 请求api服务
        byte[] result = HttpUtil.doPost("https://openapi.youdao.com/api", null, params, "application/json");
        // 打印返回结果
        if (result != null) {
            String ret = new String(result, StandardCharsets.UTF_8);
            System.out.println(ret);
            Map<String, Object> retMap = com.alibaba.fastjson.JSON.parseObject(ret);
            if(!retMap.get("errorCode").equals("0")){
                return Result.fail(null,"访问频率受限,请稍后访问");
            }
            return Result.success(retMap.get("translation").toString(),"");
        }
        return Result.fail("翻译出错");
    }
}
