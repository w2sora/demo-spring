package com.config;

import com.aspect.Audience;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"com.aspect"})
public class AspectConfig {

    @Bean
    public Audience audience() {
        return new Audience();
    }

}
