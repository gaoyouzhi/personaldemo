package com.ikang.vo;

import com.ikang.model.RmsSmsTemplate;

public class RmsSmsTemplateVo extends RmsSmsTemplate {
    private static final long serialVersionUID = 8419517724838223705L;

    /**库存名称**/
    private String warehouseName;

    /**渠道名称**/
    private String channelName;


    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

}
