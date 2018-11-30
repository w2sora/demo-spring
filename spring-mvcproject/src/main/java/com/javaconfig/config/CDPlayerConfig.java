package com.javaconfig.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.javaconfig.soundsystem")
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
