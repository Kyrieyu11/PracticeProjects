package com.vueadminproject.backend.controller;

import com.vueadminproject.backend.pojo.UserAndDeptProfile;
import com.vueadminproject.backend.pojo.UserProfile;
import com.vueadminproject.backend.service.IUserProfileService;
import com.vueadminproject.backend.service.impl.UserAndDeptProfileServiceImpl;
import com.vueadminproject.backend.service.impl.UserProfileServiceImpl;
import com.vueadminproject.backend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserAndDeptController {
    @Autowired
    private UserAndDeptProfileServiceImpl userAndDeptProfileService;
    @Autowired
    private IUserProfileService userProfileService;
    @GetMapping("/getuseranddept")
    public Result<List<UserAndDeptProfile>> getuseranddept(){
        List<UserAndDeptProfile> getusersanddept = userAndDeptProfileService.getUserAndDept();
        return Result.success(getusersanddept,"成功返回结果");
    }
    @GetMapping("/getusers")
    public Result<List<UserProfile>> getusers(@RequestParam("deptId") int deptId){
        List<UserProfile> getusers = userProfileService.getusers(deptId);
        return Result.success(getusers,"返回成功");
    }
}
