package com.telecomyt.web.manage;

import com.alibaba.druid.util.StringUtils;
import com.telecomyt.web.entity.H5DetailInfo;
import com.telecomyt.web.entity.H5Info;
import com.telecomyt.web.exception.CustomException;
import com.telecomyt.web.mapper.html.H5Mapper;
import com.telecomyt.web.mapper.primary.OrganizationMapper;
import com.telecomyt.web.result.BaseResp;
import com.telecomyt.web.result.ResultStatus;
import com.telecomyt.web.service.IHtmlService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: web
 * @ClassName: HtmlController
 * @Description: h5 controller
 * @Author: zhoupengbing
 * @modified: zhoupengbing
 * @Date: 2018/7/26 13:51
 */
@Api(tags="应用管理模块接口",position = 1)
@RestController("/html")
public class HtmlController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    H5Mapper h5Mapper;

    @Autowired
    OrganizationMapper orgaMapper;

    @Autowired
    IHtmlService htmlService;

    @ApiOperation(value="测试多数据源",hidden = true)
    @GetMapping("/test")
    @ApiResponses({@ApiResponse(code = 200, message = "请求成功"),
                   @ApiResponse(code = 400, message = "请求失败"),
                   @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    public BaseResp testDymanicDataSource(){
        List<Object> data = new ArrayList<>();
        try{
            data.add(orgaMapper.getOrganizationByCode("000000000000"));
//        data.add(h5Mapper.queryUserById("1"));
        }catch(Exception e){
            e.printStackTrace();
        }
        return new BaseResp(ResultStatus.SUCCESS,data);
    }

    @ApiOperation(value="添加H5应用",notes = "添加H5应用id不用传，系统处理")
    @ResponseBody
    @PostMapping("/add")
    @ApiImplicitParams(
        {
            @ApiImplicitParam(name = "orgas", value = "机构编码,逗号隔开,可以为空,为空就是全局可用", required = false, paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "idCards", value = "身份证号,逗号隔开,可以为空", required = false, paramType = "query",dataType = "String")
        }
    )
    public BaseResp addHtml(H5Info info,String orgas,String idCards){
        if(!StringUtils.isEmpty(info.getClientId())
                && !StringUtils.isEmpty(info.getName())
                && !StringUtils.isEmpty(info.getUrl())){
            try{
                String [] orga = {};
                String [] idCard = {};
                if(!StringUtils.isEmpty(orgas)){
                    orga = orgas.split(",");
                }
                if(!StringUtils.isEmpty(idCards)){
                    idCard = idCards.split(",");
                }
                boolean isSuccess = this.htmlService.addHtml(info,orga,idCard);
                if(isSuccess){
                    return new BaseResp(ResultStatus.SUCCESS,"");
                }else{
                    return new BaseResp(ResultStatus.FAIL);
                }
            }catch(CustomException e){
                logger.error("msg"+e.getMessage());
                throw new CustomException(e.getCode(),e.getMsg());
            }catch(Exception e){
                logger.error("msg"+e.getMessage());
                throw new CustomException(ResultStatus.http_status_internal_server_error.getErrorCode(),ResultStatus.http_status_internal_server_error.getErrorMsg());
            }
        }else{
            throw new CustomException(ResultStatus.request_param_is_null.getErrorCode(),ResultStatus.request_param_is_null.getErrorMsg());
        }
    }

    @ApiOperation(value="获取应用列表信息",notes="获取应用列表信息")
    @GetMapping("/list")
    @ResponseBody
    public BaseResp getHtmlList(){
        try{
            List<H5Info>h5List = this.htmlService.getHtmlList();
            return new BaseResp(ResultStatus.SUCCESS,h5List);
        }catch(CustomException e){
            throw new CustomException(e.getCode(),e.getMsg());
        }catch(Exception e){
            throw new CustomException(ResultStatus.http_status_internal_server_error.getErrorCode(),ResultStatus.http_status_internal_server_error.getErrorMsg());
        }
    }

    @ResponseBody
    @PostMapping("/get")
    @ApiOperation(value="获取应用信息",notes = "根据应用的id查询应用的详细信息")
    @ApiImplicitParam(name = "id", value = "应用的id", required = true, paramType = "query")
    public BaseResp getH5Info(String id){
        if(!StringUtils.isEmpty(id)){
            try{
                H5DetailInfo info = this.htmlService.getH5Info(id);
                return new BaseResp(ResultStatus.SUCCESS,info);
            }catch(CustomException e){
                e.printStackTrace();
                logger.error("msg"+e.getMessage());
                throw new CustomException(e.getCode(),e.getMsg());
            }catch(Exception e){
                e.printStackTrace();
                logger.error("msg"+e.getMessage());
                throw new CustomException(ResultStatus.http_status_internal_server_error.getErrorCode(),ResultStatus.http_status_internal_server_error.getErrorMsg());
            }
        }else{
            throw new CustomException(ResultStatus.request_param_is_null.getErrorCode(),ResultStatus.request_param_is_null.getErrorMsg());
        }
    }

    @ResponseBody
    @PostMapping("/edit")
    @ApiOperation(value="更改应用的信息",notes="更改应用的信息，只需传应用被更改的属性信息即可")
    @ApiImplicitParams(
        {
            @ApiImplicitParam(name = "id", value = "应用的id，不可缺少", required = true, paramType = "query"),
            @ApiImplicitParam(name = "icon", value = "应用的图标", required = false, paramType = "query"),
            @ApiImplicitParam(name = "description", value = "应用描述信息", required = false, paramType = "query"),
            @ApiImplicitParam(name = "url", value = "应用地址", required = false, paramType = "query"),
            @ApiImplicitParam(name = "version", value = "应用版本号", required = false, paramType = "query"),
            @ApiImplicitParam(name = "status", value = "应用状态，0启用，1停用，2注销", required = false, paramType = "query"),
            @ApiImplicitParam(name = "orgas", value = "应用所属的机构,逗号隔开,没变动就传空,权限变更为空就传1", required = false, paramType = "query"),
            @ApiImplicitParam(name = "idCards", value = "应用所属的人身份证号，逗号隔开,没变动就传空,权限变更为空，就传1", required = false, paramType = "query")
        }
    )
    public BaseResp editH5Info(String id,String icon,String name,String description,String url,String status,String version,String orgas,String idCards)throws Exception{
        if(!StringUtils.isEmpty(id)){
            String [] orga = {};
            String [] idCard = {};
            if(!StringUtils.isEmpty(orgas)){
                orga = orgas.split(",");
            }
            if(!StringUtils.isEmpty(idCards)){
                idCard = idCards.split(",");
            }
            int num = this.htmlService.editH5Info(id,icon,name,description,url,status,version,orga,idCard);
            if(num > 0){
                return new BaseResp(ResultStatus.SUCCESS,"");
            }else{
                return new BaseResp(ResultStatus.FAIL);
            }
        }else{
            throw new CustomException(com.telecomyt.web.enums.ResultStatus.request_param_is_null.getErrorCode(),ResultStatus.request_param_is_null.getErrorMsg());
        }
    }

    @ResponseBody
    @ApiOperation(value="app用户获取应用列表",notes = "app用户获取权限内应用列表信息")
    @PostMapping("/app/list")
    @ApiImplicitParam(name="idCard",value="用户身份证号,不可为空",required = true,paramType = "query",dataType = "String")
    public BaseResp getUserH5List(String idCard){
        if(!StringUtils.isEmpty(idCard)){
            try{
                List<H5Info>list = this.htmlService.getUserH5List(idCard);
                return new BaseResp(ResultStatus.SUCCESS,list);
            }catch(CustomException e){
                e.printStackTrace();
                throw new CustomException(e.getCode(),e.getMsg());
            }catch(Exception e){
                e.printStackTrace();
                throw new CustomException(ResultStatus.http_status_internal_server_error.getErrorCode(),ResultStatus.http_status_internal_server_error.getErrorMsg());
            }
        }else{
            throw new CustomException(com.telecomyt.web.enums.ResultStatus.request_param_is_null.getErrorCode(),ResultStatus.request_param_is_null.getErrorMsg());
        }
    }
}
