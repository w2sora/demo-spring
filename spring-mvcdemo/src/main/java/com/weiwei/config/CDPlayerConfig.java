package com.weiwei.config;

import com.weiwei.soundsystem.CDPlayer;
import com.weiwei.soundsystem.CompactDisc;
import com.weiwei.soundsystem.SgtPeppers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// @ComponentScan(basePackages = "com.weiwei.soundsystem")
public class CDPlayerConfig {
    @Bean(name = "lonelyHeart")
    public CompactDisc sgtPeppers() {
        return new SgtPeppers();
    }

    @Bean
    public CDPlayer cdPlayer(CompactDisc compactDisc) {
        return new CDPlayer(compactDisc);
    }
}
