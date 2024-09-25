package com.vueadminproject.backend.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sun.javafx.collections.MappingChange;
import com.vueadminproject.backend.dao.UserProfileMapper;
import com.vueadminproject.backend.pojo.UserProfile;
import com.vueadminproject.backend.service.impl.UserProfileServiceImpl;
import com.vueadminproject.backend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private UserProfileServiceImpl userProfileService;
    @PostMapping("/login")
    public Result<String> login(@RequestParam("username") String username,
                                @RequestParam("password") String password){
        String login = userProfileService.login(username,password);
        if(login != null){
            return Result.success(login,"Login Success");
        }
        return Result.fail("Username Or Password Error");
    }
    @GetMapping("/info")
    public Result<String> getInfo(@RequestHeader("X-Token") String token){
        UserProfile info = userProfileService.getUserInfo(token);
        if(info != null){
            String jsonString = JSON.toJSONString(info);
            return Result.success(jsonString,"Success Get UserInfo");
        }
        return Result.fail("GetUserInfoError");
    }
    @PostMapping("/logout")
    public  Result<String> logout(@RequestHeader("X-Token") String token){
        UserProfile logout = userProfileService.logout(token);
        if(logout!=null){
            return Result.success("Success Log Out");
        }
        return Result.fail("Log Out Error");
    }
}
