package com.telecomyt.web.service.impl;

import com.telecomyt.web.entity.Organization;
import com.telecomyt.web.mapper.primary.IPrimaryMapper;
import com.telecomyt.web.service.IPrimaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: web
 * @ClassName: PrimaryService
 * @Description:
 * @Author: dianxinyitong
 * @modified:
 * @Date: 2018/7/27 14:01
 */
@Service
public class PrimaryService implements IPrimaryService{

    @Autowired
    IPrimaryMapper primaryMapper;

    @Override
    public List<Organization> queryTopOrgas(String orgaCode) throws Exception{
        List<Organization>list = new ArrayList<>();
        //为0查询顶层机构信息
        list = this.primaryMapper.queryOrgaList(orgaCode);
        return list;
    }
}
