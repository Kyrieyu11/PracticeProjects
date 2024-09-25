package com.vueadminproject.backend.service.impl;

import com.vueadminproject.backend.dao.UserAndDeptMapper;
import com.vueadminproject.backend.pojo.UserAndDeptProfile;
import com.vueadminproject.backend.pojo.UserProfile;
import com.vueadminproject.backend.service.IUserAndDeptProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAndDeptProfileServiceImpl implements IUserAndDeptProfileService {
    @Autowired
    private UserAndDeptMapper userAndDeptMapper;
    @Override
    public List<UserAndDeptProfile> getUserAndDept() {
        List<UserAndDeptProfile> userAndDept = userAndDeptMapper.getUserAndDept();
        return userAndDept;
    }
}
