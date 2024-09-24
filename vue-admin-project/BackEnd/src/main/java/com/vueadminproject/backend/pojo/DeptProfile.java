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
@TableName("dept_profile")
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DeptProfile implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "dept_id", type = IdType.AUTO)
    private Integer deptId;

    @TableField("dept_name")
    private String deptName;

    @TableField("dept_leader")
    private String deptLeader;

}
