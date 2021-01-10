package com.xnyc.blog.configure.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 有些页面需要登录才能进入，需要配置拦截页面
 *
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
        loginRegistry.addPathPatterns("/manager/**/*.html");
        loginRegistry.excludePathPatterns("/manager/managerLogin.html");

        // 排除路径
//        loginRegistry.excludePathPatterns("/**");


        // 排除资源请求
        loginRegistry.excludePathPatterns("/css/**");
        loginRegistry.excludePathPatterns("/js/**");
        loginRegistry.excludePathPatterns("/image/**");
        loginRegistry.excludePathPatterns("/index.html");
    }
}
