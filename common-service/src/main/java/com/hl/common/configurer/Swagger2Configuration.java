package com.hl.common.configurer;

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

@Configuration
@EnableSwagger2
public class Swagger2Configuration {
	
	@Bean
	public Docket buildDocket(){
	    //添加head参数start  
	     return new Docket(DocumentationType.SWAGGER_2)
	             .apiInfo(buildApiInf())
	             .select()
	             .apis(RequestHandlerSelectors.basePackage("com.hl.machine"))
	             .paths(PathSelectors.any())
	             .build();
	 }

	 private ApiInfo buildApiInf(){
	     return new ApiInfoBuilder()
	                 .title("机器语言接口")
	                 .description("springboot swagger2")
	                 .termsOfServiceUrl("http://www.nwba.com")
	                 .contact(new Contact("huanglei", "开发请找我,专业的,你懂得!", "2236170640@163.com"))
	                 .build();

	 }
}
