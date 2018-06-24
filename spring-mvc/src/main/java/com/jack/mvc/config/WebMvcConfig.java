package com.jack.mvc.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.jack.mvc.interceptor.AuthInterceptor;
import com.jack.mvc.interceptor.ExceptionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private AuthInterceptor authInterceptor;

    @Autowired
    private ExceptionInterceptor exceptionInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(exceptionInterceptor).addPathPatterns("/**");
        registry.addInterceptor(authInterceptor).addPathPatterns("/**")
            .excludePathPatterns("/swagger**/**",
                "/health", "/configprops", "/dump", "metrics/**", "/mappings", "/trace", "info",
                "/beans",
                "/metrics", "/view**/**", "/accset**/**", "/**.html", "/**.js", "*.jpg", "*.png",
                "/resources", "/static", "/monitoring**/**", "/error");
        super.addInterceptors(registry);
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteDateUseDateFormat);
        fastConverter.setFastJsonConfig(fastJsonConfig);
        converters.add(fastConverter);
    }

}