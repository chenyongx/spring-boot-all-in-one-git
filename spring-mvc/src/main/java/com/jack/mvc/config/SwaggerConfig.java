package com.jack.demo.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>Description:</p>
 * <pre></pre>
 * <p>Company: jack</p>
 *
 * @author yangyueming
 * @date 2017/11/13
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        tokenPar.name("accessToken").description("令牌").modelRef(new ModelRef("string"))
            .parameterType("header").required(false).build();
        pars.add(tokenPar.build());
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo()).select()
            .apis(RequestHandlerSelectors.basePackage("com.jack.mvc.jpa.h2.druid.demo.web"))
            .paths(PathSelectors.any()).build().globalOperationParameters(pars)
            .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        Contact contact = new Contact("yangyueming", "http://jack.com", "yangyueming@jack.com");
        return new ApiInfoBuilder().title("jack项目http接口").description("jack Api Definition")
            .version("1.0.0").license("Apache 2.0")
            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0").contact(contact).build();
    }
}
