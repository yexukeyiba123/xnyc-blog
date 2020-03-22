package com.xnyc.blog.configure.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author : 郑杜
 * @date : 2020/03/15
 */
@Configuration
public class LoginConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器
        LoginInterceptor loginInterceptor = new LoginInterceptor();
        InterceptorRegistration loginRegistry = registry.addInterceptor(loginInterceptor);
        // 拦截路径
//        loginRegistry.addPathPatterns("/**");

        // 排除路径
        loginRegistry.excludePathPatterns("/**");
//        loginRegistry.excludePathPatterns("/login_register/*");
//        loginRegistry.excludePathPatterns("/query/*");

        // 排除资源请求
//        loginRegistry.excludePathPatterns("/css/login/*.css");
//        loginRegistry.excludePathPatterns("/js/login/**/*.js");
//        loginRegistry.excludePathPatterns("/image/login/*.png");
//        loginRegistry.excludePathPatterns("/index.html");
    }
}
