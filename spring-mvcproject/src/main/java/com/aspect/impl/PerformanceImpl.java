package com.aspect.impl;

import com.aspect.Performance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PerformanceImpl implements Performance {
    private static final Logger log = LoggerFactory.getLogger(PerformanceImpl.class);

    @Override
    public void perform() {
        log.info("Nico Nico Ni~");
        // throw new RuntimeException();
    }
}
