package com.vueadminproject.backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.*;

/**
 * <p>
 *
 * </p>
 *
 * @author YSH
 * @since 2024-09-19
 */
@Getter
@Setter
@TableName("user_profile")
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    @TableField("name")
    private String name;

    @TableField("gender")
    private String gender;

    @TableField("position")
    private String position;

    @TableField("dept_id")
    private Integer deptId;
    @TableField("password")
    private String password;
}
