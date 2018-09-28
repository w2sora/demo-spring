package com.weiwei.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.weiwei.soundsystem")
public class CDPlayerConfig {

    // @Bean(name = "lonelyHeart")
    // public CompactDisc sgtPeppers() {
    //     return new SgtPeppers();
    // }
    //
    // @Bean
    // public MediaPlayer cdPlayer(CompactDisc compactDisc) {
    //     return new CDPlayer(compactDisc);
    // }
}
