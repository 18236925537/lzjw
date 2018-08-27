package com.telecomyt.web.mapper.primary;

import com.telecomyt.web.entity.Organization;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrganizationMapper {

    Organization getOrganizationByCode(@Param("code")String code);

}
