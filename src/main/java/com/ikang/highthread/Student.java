package com.ikang.highthread;

import java.io.Serializable;

/**
 * Created by gaoyouzhi on 2020/3/7.
 */
public class Student implements Serializable{
    private static final long serialVersionUID = -3683685969859057448L;
    private String name;
    private String serialNo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }
}
