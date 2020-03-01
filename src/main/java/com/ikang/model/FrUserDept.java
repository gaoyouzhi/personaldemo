package com.ikang.model;

import java.io.Serializable;

/**
 * @author gaoyouzhi
 */
public class FrUserDept implements Serializable{
    private static final long serialVersionUID = 5831909141183429532L;
    private Integer id;

    private Integer userId;

    private Integer deptId;

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

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }
}