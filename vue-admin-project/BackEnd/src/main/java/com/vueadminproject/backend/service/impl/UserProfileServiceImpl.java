package com.vueadminproject.backend.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vueadminproject.backend.dao.DeptProfileMapper;
import com.vueadminproject.backend.pojo.DeptProfile;
import com.vueadminproject.backend.pojo.UserProfile;
import com.vueadminproject.backend.dao.UserProfileMapper;
import com.vueadminproject.backend.service.IUserProfileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vueadminproject.backend.utils.GenerateToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author YSH
 * @since 2024-09-19
 */
@Service
public class UserProfileServiceImpl extends ServiceImpl<UserProfileMapper, UserProfile> implements IUserProfileService {
    @Autowired
    private  UserProfileMapper userProfileMapper;
    @Autowired
    private DeptProfileMapper deptProfileMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public String login(String username, String password) {
        QueryWrapper<UserProfile> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",username);
        UserProfile one = userProfileMapper.selectOne(queryWrapper);
        if(one != null){
            String Token = GenerateToken.GERNERATE_TOKEN();
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("userId",one.getUserId());
            hashMap.put("name",one.getName());
            hashMap.put("gender",one.getGender());
            hashMap.put("position",one.getPosition());
            hashMap.put("deptId",one.getDeptId());
            hashMap.put("token",Token);
            redisTemplate.opsForValue().set(Token,one,30, TimeUnit.MINUTES);
            String jsonString = JSON.toJSONString(hashMap);
            return  jsonString;
        }
        return null;
    }

    @Override
    public UserProfile getUserInfo(String token) {
        UserProfile userProfile = (UserProfile) redisTemplate.opsForValue().getAndExpire(token,30,TimeUnit.MINUTES);
        if(userProfile != null){
            return userProfile;
        }
        return null;
    }

    @Override
    public UserProfile logout(String token) {
        UserProfile result = (UserProfile) redisTemplate.opsForValue().getAndDelete(token);
        return result;
    }
}
