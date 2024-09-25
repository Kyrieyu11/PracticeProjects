package com.vueadminproject.backend.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vueadminproject.backend.pojo.UserAndDeptProfile;
import com.vueadminproject.backend.pojo.UserProfile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface UserAndDeptMapper extends BaseMapper<UserAndDeptProfile> {
    List<UserAndDeptProfile> getUserAndDept();
}
