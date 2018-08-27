package com.telecomyt.web.entity;

import io.swagger.annotations.ApiModel;

/**
 * @ProjectName: web
 * @ClassName: User
 * @Description:
 * @Author: dianxinyitong
 * @modified:
 * @Date: 2018/7/26 16:53
 */
@ApiModel
public class User {

    private String name;
    private String identityCard;
    private String orgaCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getOrgaCode() {
        return orgaCode;
    }

    public void setOrgaCode(String orgaCode) {
        this.orgaCode = orgaCode;
    }
}
