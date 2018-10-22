package com.xiaozhao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2配置类
 * 1）在集成spring boot时，放在与Application.java同级目录下
 * 2）@Configuration注解的作用是让spring 来加载该类的配置
 * 3）@EnableSwagger2 是用来启用swagger2
 *
 * @author xiaozhao
 * @date 2018/10/19下午3:14
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    /**
     * 指定扫描包的路径来指定要创建API的目录，一般是控制器这个包
     *
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xiaozhao.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 设置API的基本信息
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("我的公司")
                .description("后端接口说明文档")
                .termsOfServiceUrl("https://www.jianshu.com")
                .version("1.0")
                .build();
    }
}
