package com.weiwei.annotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

/**
 * 注解处理器
 */
public class FruitInfoUtil {
    private static Logger logger = LoggerFactory.getLogger(FruitInfoUtil.class);

    public static void getFruitInfo(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(FruitName.class)) {
                FruitName fruitName = (FruitName) field.getAnnotation(FruitName.class);
                String name = fruitName.value();
                logger.info("水果名称: {}", name);
            } else if (field.isAnnotationPresent(FruitColor.class)) {
                FruitColor fruitColor = (FruitColor) field.getAnnotation(FruitColor.class);
                String color = fruitColor.fruitColor().toString();
                logger.info("水果颜色: {}", color);
            } else if (field.isAnnotationPresent(FruitProvider.class)) {
                FruitProvider fruitProvider = (FruitProvider) field.getAnnotation(FruitProvider.class);
                int id = fruitProvider.id();
                String name = fruitProvider.name();
                String address = fruitProvider.address();
                logger.info("供应商编号: {}, 供应商名称: {}, 供应商地址: {}", id, name, address);
            }
        }
    }
}
