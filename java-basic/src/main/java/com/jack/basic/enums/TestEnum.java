package com.jack.basic.enums;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yangyueming
 */
@Slf4j
public class TestEnum {
    public static void main(String[] args) {
        for (JackEnum jackEnum : JackEnum.values()) {
            switch (jackEnum) {
                case SPRING:
                    log.info("spring");
                    break;
                case SUMMER:
                    log.info("summer");
                    break;
                case FALL:
                    log.info("fall");
                    break;
                case WINTER:
                    log.info("winter");
                    break;
                    default:;
            }
        }
    }
}
