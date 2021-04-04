package ru.kostiakov.starter.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.kostiakov.starter.interceptor.GoodbyeInterceptor;
import ru.kostiakov.starter.interceptor.HelloInterceptor;

@Configuration
@EnableConfigurationProperties(InterceptorProperties.class)
public class InterceptorMvcConfigurer implements WebMvcConfigurer {

    private final HelloInterceptor helloInterceptor;
    private final GoodbyeInterceptor goodbyeInterceptor;
    private final InterceptorProperties interceptorProperties;

    public InterceptorMvcConfigurer(InterceptorProperties interceptorProperties) {
        this.interceptorProperties = interceptorProperties;
        this.helloInterceptor = new HelloInterceptor();
        this.goodbyeInterceptor = new GoodbyeInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        if (interceptorProperties.isEnabledHelloInterceptor()) {
            registry.addInterceptor(helloInterceptor);
        }
        if (interceptorProperties.isEnabledGoodbyeInterceptor()) {
            registry.addInterceptor(goodbyeInterceptor);
        }
    }
}
