package com.telecomyt.web.manage.primary;

import com.alibaba.druid.util.StringUtils;
import com.telecomyt.web.entity.Organization;
import com.telecomyt.web.exception.CustomException;
import com.telecomyt.web.result.BaseResp;
import com.telecomyt.web.result.ResultStatus;
import com.telecomyt.web.service.IPrimaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ProjectName: web
 * @ClassName: PrimaryController
 * @Description: 基础服务入口
 * @Author: dianxinyitong
 * @modified:
 * @Date: 2018/7/27 13:32
 */
@Api(tags="机构管理模块接口",position = 0)
@RestController
@RequestMapping("/base")
public class PrimaryController {

    @Autowired
    IPrimaryService primaryService;

    @PostMapping("/orga/list")
    @ApiOperation(value="获取机构列表信息",response = BaseResp.class)
    @ApiImplicitParam(value="查询的机构编码，为1查询顶层机构，不为1查询下级机构",name="orgaCode",paramType = "query",
                      dataType = "String",required = true)
    public BaseResp queryTopOrgas(String orgaCode){
        if(!StringUtils.isEmpty(orgaCode)){
            try{
                List<Organization> organizations = this.primaryService.queryTopOrgas(orgaCode);
                return new BaseResp(ResultStatus.SUCCESS,organizations);
            }catch(Exception e){
                e.printStackTrace();
                //系统异常
                throw new CustomException(ResultStatus.http_status_internal_server_error.getErrorCode(),ResultStatus.http_status_internal_server_error.getErrorMsg());
            }
        }else{
            //参数不能为空
            throw new CustomException(ResultStatus.request_param_is_null.getErrorCode(),ResultStatus.request_param_is_null.getErrorMsg());
        }

    }

}
