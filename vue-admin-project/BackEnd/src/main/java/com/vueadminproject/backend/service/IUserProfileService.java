package com.vueadminproject.backend.service;

import com.vueadminproject.backend.pojo.UserProfile;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.tomcat.jni.User;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author YSH
 * @since 2024-09-19
 */
public interface IUserProfileService extends IService<UserProfile> {
    String login(String username,String password);
    UserProfile getUserInfo(String token);
    UserProfile  logout(String token);
    List<UserProfile> getusers();
    List<UserProfile> getusers(int deptId);
}
