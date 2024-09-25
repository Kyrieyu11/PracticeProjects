package com.vueadminproject.backend.service;

import com.vueadminproject.backend.pojo.UserAndDeptProfile;
import com.vueadminproject.backend.pojo.UserProfile;

import java.util.List;

public interface IUserAndDeptProfileService {
    List<UserAndDeptProfile> getUserAndDept();
}
