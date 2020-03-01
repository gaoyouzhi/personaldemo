package com.ikang.model;

import java.io.Serializable;

/**
 * @Description 描述：用户角色
 * @Author: youzhi.gao@ikang.com
 * @Date: 2020-01-20 17:19
 */
public class FrUserRole implements Serializable {
    private static final long serialVersionUID = 1690494108159659773L;
    private Integer id;

    private Integer userId;

    private Integer roleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}