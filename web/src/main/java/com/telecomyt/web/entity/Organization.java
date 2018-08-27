package com.telecomyt.web.entity;

/**
 * @ProjectName: web
 * @ClassName: Organization
 * @Description:
 * @Author: dianxinyitong
 * @modified:
 * @Date: 2018/7/26 16:58
 */
public class Organization {

    private String orgaCode;
    private String orgaName;
    private String superCode;
    private int isSelected;

    public String getOrgaCode() {
        return orgaCode;
    }

    public void setOrgaCode(String orgaCode) {
        this.orgaCode = orgaCode;
    }

    public String getOrgaName() {
        return orgaName;
    }

    public void setOrgaName(String orgaName) {
        this.orgaName = orgaName;
    }

    public String getSuperCode() {
        return superCode;
    }

    public void setSuperCode(String superCode) {
        this.superCode = superCode;
    }

    public int getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(int isSelected) {
        this.isSelected = isSelected;
    }
}
