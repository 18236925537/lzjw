package com.telecomyt.web.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @ProjectName: web
 * @ClassName: H5Info
 * @Description: h5应用实体类
 * @Author: dianxinyitong
 * @modified:
 * @Date: 2018/7/27 10:02
 */
@ApiModel
public class H5Info {

    @ApiModelProperty(value = "数据库主键id，创建可以为空", name = "province", hidden = true)
    private int id;
    @ApiModelProperty(value = "应用唯一标识", name = "clientId", required = true)
    private String clientId;
    @ApiModelProperty(value = "应用名称", name = "name", required = true)
    private String name;
    @ApiModelProperty(value = "应用图标，base64编码", name = "icon", required = true)
    private String icon;
    @ApiModelProperty(value = "创建时间", name = "createDate", hidden = true)
    private Date createDate;
    @ApiModelProperty(value = "更新时间", name = "updateDate", hidden = true)
    private Date updateDate;
    @ApiModelProperty(value = "应用描述", name = "description", required = true)
    private String description;
    @ApiModelProperty(value = "应用地址", name = "url", required = true)
    private String url;
    @ApiModelProperty(value = "应用状态,0启用，1停用，2注销", name = "status", hidden = true)
    private String status;
    @ApiModelProperty(value = "应用顺序", name = "orderNum", hidden = true)
    private String orderNum;
    @ApiModelProperty(value = "应用版本", name = "version", hidden = true)
    private String version;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}