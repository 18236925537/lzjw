package com.telecomyt.web.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ProjectName: web
 * @ClassName: conf
 * @Description: swagger配置
 * @Author: dianxinyitong
 * @modified:
 * @Date: 2018/7/27 9:33
 */
@Configuration
@EnableSwagger2
public class SwagerConf {

    @Bean
    public Docket buildDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInf())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.telecomyt.web.manage"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo buildApiInf(){
        return new ApiInfoBuilder()
                .title("电信易通-H5后台接口文档")
                .description("电信易通-H5后台接口文档")
                .version("1.0.0")
////                .termsOfServiceUrl("http://blog.csdn.net/u014231523网址链接")
//                .contact(new Contact("zhoupengbing", "localhost/swagger-ui.html", "zhoupengbing@telecomyt.com.cn"))
                .build();

    }

}
