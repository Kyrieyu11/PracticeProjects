package com.vueadminproject.backend;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vueadminproject.backend.dao.DeptProfileMapper;
import com.vueadminproject.backend.dao.UserAndDeptMapper;
import com.vueadminproject.backend.dao.UserProfileMapper;
import com.vueadminproject.backend.pojo.DeptProfile;
import com.vueadminproject.backend.pojo.UserAndDeptProfile;
import com.vueadminproject.backend.pojo.UserProfile;
import com.vueadminproject.backend.utils.GenerateToken;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

@SpringBootTest
class BackEndApplicationTests {
    @Autowired
    private UserAndDeptMapper userAndDeptMapper;
    @Autowired
    private  RedisTemplate redisTemplate;
//    @Test
//    void contextLoads() {
//        UserProfile userProfile = userProfileMapper.selectById(1);
//        String jsonString = JSON.toJSONString(userProfile);
//        System.out.println(jsonString);
//    }
//    @Test
//    void testRedis() {
//        redisTemplate.opsForValue().set("name","ysh");
//        String result = (String) redisTemplate.opsForValue().get("name");
//        System.out.println(result);
//    }
//    @Test
//    void testJson(){
//        QueryWrapper<UserProfile> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("name","Alice Smith");
//        UserProfile one = userProfileMapper.selectOne(queryWrapper);
//        HashMap<String, Object> hashMap = new HashMap<>();
//        hashMap.put("userId",one.getUserId());
//        hashMap.put("name",one.getName());
//        hashMap.put("gender",one.getGender());
//        hashMap.put("position",one.getPosition());
//        hashMap.put("deptId",one.getDeptId());
//        hashMap.put("token","12312312");
//        String jsonString = JSON.toJSONString(hashMap);
//        System.out.println(jsonString);
//    }
//    @Test
//    void generateToken(){
//        String s = GenerateToken.GERNERATE_TOKEN();
//        System.out.println(s);
//    }
//    @Test
//    void helloworld(){
//        System.out.println("helloworld");
//    }

//    @Test
//    void testUserAndProfile(){
//        List<UserAndDeptProfile> userAndDept = userAndDeptMapper.getUserAndDept();
//        userAndDept.forEach(userAndDeptProfile -> System.out.println(userAndDeptProfile.toString()));
//    }
}
