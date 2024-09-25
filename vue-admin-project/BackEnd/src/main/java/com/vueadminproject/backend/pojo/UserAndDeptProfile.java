package com.vueadminproject.backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserAndDeptProfile implements Serializable {
    private Integer userId;

    private String name;


    private String gender;


    private String position;

    private Integer deptId;


    private String deptName;

    private String deptLeader;
}
