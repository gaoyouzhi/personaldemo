package com.haochang.model;

import java.io.Serializable;
import java.util.Date;

public class RmsSmsTemplate implements Serializable {


    private static final long serialVersionUID = -6379864077739693940L;
    private Long cId;

    private Long cWarehouseId;

    private Long cChannelId;

    private Long cType;

    private String cSmsTemplate;

    private Long cStatus;

    private String cCreatedby;

    private Date cCreatedon;

    private String cOpUser;

    private Date cOpTime;

    private Long cIsPriority;

    private Date cStartdate;

    private Date cEnddate;

    private Long cGoodsTpye;

    public Long getcId() {
        return cId;
    }

    public void setcId(Long cId) {
        this.cId = cId;
    }

    public Long getcWarehouseId() {
        return cWarehouseId;
    }

    public void setcWarehouseId(Long cWarehouseId) {
        this.cWarehouseId = cWarehouseId;
    }

    public Long getcChannelId() {
        return cChannelId;
    }

    public void setcChannelId(Long cChannelId) {
        this.cChannelId = cChannelId;
    }

    public Long getcType() {
        return cType;
    }

    public void setcType(Long cType) {
        this.cType = cType;
    }

    public String getcSmsTemplate() {
        return cSmsTemplate;
    }

    public void setcSmsTemplate(String cSmsTemplate) {
        this.cSmsTemplate = cSmsTemplate;
    }

    public Long getcStatus() {
        return cStatus;
    }

    public void setcStatus(Long cStatus) {
        this.cStatus = cStatus;
    }

    public String getcCreatedby() {
        return cCreatedby;
    }

    public void setcCreatedby(String cCreatedby) {
        this.cCreatedby = cCreatedby;
    }

    public Date getcCreatedon() {
        return cCreatedon;
    }

    public void setcCreatedon(Date cCreatedon) {
        this.cCreatedon = cCreatedon;
    }

    public String getcOpUser() {
        return cOpUser;
    }

    public void setcOpUser(String cOpUser) {
        this.cOpUser = cOpUser;
    }

    public Date getcOpTime() {
        return cOpTime;
    }

    public void setcOpTime(Date cOpTime) {
        this.cOpTime = cOpTime;
    }

    public Long getcIsPriority() {
        return cIsPriority;
    }

    public void setcIsPriority(Long cIsPriority) {
        this.cIsPriority = cIsPriority;
    }

    public Date getcStartdate() {
        return cStartdate;
    }

    public void setcStartdate(Date cStartdate) {
        this.cStartdate = cStartdate;
    }

    public Date getcEnddate() {
        return cEnddate;
    }

    public void setcEnddate(Date cEnddate) {
        this.cEnddate = cEnddate;
    }

    public Long getcGoodsTpye() {
        return cGoodsTpye;
    }

    public void setcGoodsTpye(Long cGoodsTpye) {
        this.cGoodsTpye = cGoodsTpye;
    }

    @Override
    public String toString() {
        return "RmsSmsTemplate{" +
                "cId=" + cId +
                ", cWarehouseId=" + cWarehouseId +
                ", cChannelId=" + cChannelId +
                ", cType=" + cType +
                ", cSmsTemplate='" + cSmsTemplate + '\'' +
                ", cStatus=" + cStatus +
                ", cCreatedby='" + cCreatedby + '\'' +
                ", cCreatedon=" + cCreatedon +
                ", cOpUser='" + cOpUser + '\'' +
                ", cOpTime=" + cOpTime +
                ", cIsPriority=" + cIsPriority +
                ", cStartdate=" + cStartdate +
                ", cEnddate=" + cEnddate +
                ", cGoodsTpye=" + cGoodsTpye +
                '}';
    }
}
