package com.telecomyt.web.mapper.html;

import com.telecomyt.web.entity.H5DetailInfo;
import com.telecomyt.web.entity.H5Info;
import com.telecomyt.web.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ProjectName: web
 * @ClassName: H5Mapper
 * @Description:
 * @Author: dianxinyitong
 * @modified:
 * @Date: 2018/7/26 16:32
 */
@Mapper
public interface H5Mapper {

    /**
     * 添加应用信息
     * @param info
     * @return
     */
    void addHtmlInfo(H5Info info);

    /**
     * 添加应用记录
     * @param info
     */
    void addHtmlRecord(H5Info info);

    /**
     * 添加应用机构权限信息
     * @param clientId
     * @param orgaCode
     */
    void addH5AuthOrga(@Param("clientId")String clientId,@Param("orgaCode")String orgaCode,@Param("isSelected")int isSelected);

    /**
     * 添加应用人员权限信息
     * @param clientId
     * @param idCard
     */
    void addH5AuthUser(@Param("clientId")String clientId,@Param("idCard")String idCard);

    /**
     * 添加应用权限视图
     * @param clientId
     * @param viewName
     */
    void createH5View(@Param("clientId")String clientId,@Param("viewName")String viewName);

    /**
     * 获取应用列表
     * @return
     */
    List<H5Info> getHtmlList();

    /**
     * 获取h5详细信息
     * @param id
     * @return
     */
    H5Info getH5Info(@Param("id")String id);

    /**
     * 编辑应用的详细信息
     * @param id
     * @param icon
     * @param name
     * @param description
     * @param url
     * @param status
     */
    void editH5Info(@Param("id")String id,@Param("icon")String icon, @Param("name")String name,
                    @Param("description")String description, @Param("url")String url, @Param("status")String status,
                    @Param("version")String version);

    /**
     * 根据应用的标识查询应用基本信息
     * @param clientId
     * @return
     */
    H5Info getH5ByClientId(@Param("clientId")String clientId);

    /**
     * 更具clientId清空应用的机构权限信息
     * @param clientId
     */
    void clearH5AuthOrga(@Param("clientId")String clientId);

    /**
     * 根据应用的id清空应用的人员权限信息
     * @param clientId
     */
    void clearH5AuthUser(@Param("clientId")String clientId);

    /**
     * 获取所有的正在使用的应用的视图信息
     * @return
     */
    List<String> getUsingH5Views();

    /**
     * 查询包含当前身份证号的视图信息
     * @param viewName
     * @param idCard
     * @return
     */
    String getUserFromView(@Param("viewName")String viewName,@Param("idCard")String idCard);

    /**
     * 根据视图查询h5应用信息
     * @param viewName
     * @return
     */
    H5Info getH5InfoByViewName(@Param("viewName")String viewName);

    /**
     * 获取应用的详细信息
     * @param id
     * @return
     */
    H5DetailInfo getH5DetailInfo(@Param("id")String id);
}
