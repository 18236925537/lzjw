package com.telecomyt.web.service;

import com.telecomyt.web.entity.H5DetailInfo;
import com.telecomyt.web.entity.H5Info;

import java.util.List; /**
 * @ProjectName: web
 * @ClassName: IHtmlService
 * @Description:
 * @Author: dianxinyitong
 * @modified:
 * @Date: 2018/7/28 19:59
 */
public interface IHtmlService {

    /**
     * 添加h5应用
     * @param info 应用详情
     * @param orgas 应用权限机构编码
     * @param idCards 应用权限人员身份证号
     * @return
     */
    boolean addHtml(H5Info info, String [] orgas, String [] idCards)throws Exception;

    /**
     * 获取h5应用列表信息
     * @return
     */
    List<H5Info> getHtmlList();

    /**
     * 获取应用详细信息
     * @return
     */
    H5DetailInfo getH5Info(String id);

    /**
     * 编辑应用信息
     * @param id
     * @param icon
     * @param name
     * @param description
     * @param url
     * @param status
     * @param orgas
     * @param idCards
     * @return
     */
    int editH5Info(String id, String icon, String name, String description, String url, String status,String version, String[] orgas, String[] idCards)throws Exception;

    /**
     * app获取用户可以使用的应用列表
     * @param idCard
     * @return
     */
    List<H5Info> getUserH5List(String idCard)throws Exception;
}
