package com.sinosoft.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by houzhipeng on 2016/11/29.
 */
@Configuration
@EnableSwagger2
@ComponentScan(basePackages = {"com.sinosoft.controller"})
public class SwaggerConfiguration {

    /**
     * 扫描Controller下所有的API接口 并将其加入到RestFul中
     *
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sinosoft.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("项目接口 Restful APIs")
                .description("项目接口")
                .termsOfServiceUrl("")
                .version("1.0")
                .build();
    }
}
