package com.telecomyt.web.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.telecomyt.web.entity.H5DetailInfo;
import com.telecomyt.web.entity.H5Info;
import com.telecomyt.web.entity.Organization;
import com.telecomyt.web.enums.ResultStatus;
import com.telecomyt.web.exception.CustomException;
import com.telecomyt.web.mapper.html.H5Mapper;
import com.telecomyt.web.mapper.primary.IPrimaryMapper;
import com.telecomyt.web.service.IHtmlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ProjectName: web
 * @ClassName: HtmlServiceImpl
 * @Description:
 * @Author: dianxinyitong
 * @modified:
 * @Date: 2018/7/28 20:00
 */
@Service
public class HtmlServiceImpl implements IHtmlService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    ExecutorService pool = Executors.newFixedThreadPool(10);

    @Autowired
    IPrimaryMapper primaryMapper;
    @Autowired
    H5Mapper h5Mapper;

    @Override
    @Transactional
    public boolean addHtml(H5Info info,String [] orgas, String[] idCards){
        final String [] orga = new String[1];
        //添加应用详情
        info.setCreateDate(new Date());
        info.setUpdateDate(info.getCreateDate());
        //添加应用信息
        if(StringUtils.isEmpty(info.getVersion())){
            info.setVersion("1.0.0");
        }
        //判断应用标识是否存在
        H5Info h5Info = this.h5Mapper.getH5ByClientId(info.getClientId());
        if(h5Info != null){
            throw new CustomException(ResultStatus.clientId_exists.getErrorCode(),ResultStatus.clientId_exists.getErrorMsg());
        }else{
            this.h5Mapper.addHtmlInfo(info);
            //添加应用记录
            this.h5Mapper.addHtmlRecord(info);
            System.out.println(Arrays.toString(orgas));
            // 添加应用的机构权限信息
            if(orgas != null && orgas.length > 0){
                pool.execute(new Runnable() {
                    @Override
                    public void run() {
                        addH5AuthOrga(orgas,info.getClientId());
                    }
                });
            }else{
                //添加应用机构权限信息（全局权限）
                orga[0] = "110000000000";
                pool.execute(new Runnable() {
                    @Override
                    public void run() {
                        addH5AuthOrga(orga,info.getClientId());
                    }
                });
            }
            //添加应用人员权限信息
            if(idCards != null && idCards.length > 0){
                for(int i = 0;i < idCards.length;i++){
                    this.h5Mapper.addH5AuthUser(info.getClientId(),idCards[i]);
                }
            }
            //创建应用权限视图
            this.h5Mapper.createH5View(info.getClientId(),"view_"+info.getClientId());
        }
        return true;
    }

    /**
     * 添加应用的机构权限信息
     * @param orgas
     */
    public void addH5AuthOrga(String [] orgas,String clientId){
        List<Organization>allOrgas = new ArrayList<>();
        for(int i = 0;i < orgas.length;i++){
            Organization orga = new Organization();
            orga.setOrgaCode(orgas[i]);
            orga.setIsSelected(1);
            List<Organization>list = this.primaryMapper.getChildOrgaBySuperCode(orgas[i]);
            allOrgas.add(orga);
            if(list != null && list.size() > 0){
                allOrgas.addAll(list);
                allOrgas = getChildOrga(list,allOrgas);
            }
        }

        //添加应用的机构权限信息
        if(allOrgas != null && allOrgas.size() > 0){
            for(int i = 0;i < allOrgas.size();i++){
                this.h5Mapper.addH5AuthOrga(clientId,allOrgas.get(i).getOrgaCode(),allOrgas.get(i).getIsSelected());
            }
        }
    }

    /**
     * 获取子机构信息
     * @return
     */
    public List getChildOrga(List<Organization>list,List<Organization>allOrgas){
        List<Organization>orgaList = new ArrayList<>();
        for(int i = 0;i < list.size();i++){
            orgaList = this.primaryMapper.getChildOrgaBySuperCode(list.get(i).getOrgaCode());
            if(orgaList != null && orgaList.size() > 0){
                allOrgas.addAll(orgaList);
                getChildOrga(orgaList,allOrgas);
            }
        }
        return allOrgas;
    }

    @Override
    @Transactional
    public List<H5Info> getHtmlList() {
        try{
            return this.h5Mapper.getHtmlList();
        }catch(Exception e){
            e.printStackTrace();
            throw new CustomException(ResultStatus.FAIL.getErrorCode(),ResultStatus.FAIL.getErrorMsg());
        }
    }

    @Override
    @Transactional
    public H5DetailInfo getH5Info(String id) {
        return this.h5Mapper.getH5DetailInfo(id);
    }

    @Override
    @Transactional
    public int editH5Info(String id, String icon, String name, String description, String url, String status,String version, String[] orgas, String[] idCards)throws Exception {
        H5Info info = this.h5Mapper.getH5Info(id);
        if(info != null){
            if(!StringUtils.isEmpty(icon) || !StringUtils.isEmpty((name)) || !StringUtils.isEmpty(description) ||
                    !StringUtils.isEmpty(url) || !StringUtils.isEmpty(status) || !StringUtils.isEmpty(version)){
                //更改应用的信息
                this.h5Mapper.editH5Info(id,icon,name,description,url,status,version);
            }
            //有机构权限变更
            if(orgas != null && orgas.length > 0){
                //清空当前h5应用的机构权限
                this.h5Mapper.clearH5AuthOrga(info.getClientId());
                //添加新的权限
                //机构权限清空的时候传1,为1清空权限不添加
                if(!orgas[0].equals("1")){
                    pool.execute(new Runnable() {
                        @Override
                        public void run() {
                            addH5AuthOrga(orgas,info.getClientId());
                        }
                    });
                }
            }else{}
            //有人员权限变更
            if(idCards != null && idCards.length > 0){
                //清空人员权限
                this.h5Mapper.clearH5AuthUser(info.getClientId());
                //添加新的人员权限
                //人员权限清空的时候传1,为1清空权限不添加
                if(!idCards[0].equals("1")){
                    for(int i = 0;i < idCards.length;i++){
                        this.h5Mapper.addH5AuthUser(info.getClientId(),idCards[i]);
                    }
                }
            }
            return 1;
        }else{
            throw new CustomException(ResultStatus.INVALID_PARAM.getErrorCode(),ResultStatus.INVALID_PARAM.getErrorMsg());
        }
    }

    @Override
    public List<H5Info> getUserH5List(String idCard)throws Exception{
        List<H5Info>list = new ArrayList<>();
        //获取所有正在使用的应用视图信息
        List<String>viewNames = this.h5Mapper.getUsingH5Views();
        if(viewNames != null && viewNames.size() > 0){
            for(int i = 0;i < viewNames.size();i++){
                try{
                    String exits = this.h5Mapper.getUserFromView(viewNames.get(i),idCard);
                    if(!StringUtils.isEmpty(exits)){
                        list.add(this.h5Mapper.getH5InfoByViewName(viewNames.get(i)));
                    }
                }catch(Exception e){
                    continue;
                }
            }
        }
        return list;
    }
}
