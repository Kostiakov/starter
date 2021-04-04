package ru.kostiakov.starter.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "spring.starter.custom")
public class InterceptorProperties {

    private boolean enabledHelloInterceptor = false;
    private boolean enabledGoodbyeInterceptor = false;

}
