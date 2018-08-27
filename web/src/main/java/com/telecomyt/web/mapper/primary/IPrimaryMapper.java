package com.telecomyt.web.mapper.primary;

import com.telecomyt.web.entity.Organization;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ProjectName: web
 * @ClassName: IPrimaryMapper
 * @Description:
 * @Author: dianxinyitong
 * @modified:
 * @Date: 2018/7/27 16:26
 */
@Mapper
public interface IPrimaryMapper {

    List<Organization> queryOrgaList(@Param("orgaCode")String orgaCode);

    /**
     * 根据上级机构编码查询下级机构信息
     * @param orgas
     * @return
     */
    List<Organization> getChildOrgaBySuperCode(@Param("orgas")String orgas);
}
