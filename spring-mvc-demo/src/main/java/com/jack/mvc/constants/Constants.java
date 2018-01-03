package com.jack.constants;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 常量类
 *
 * @author yangyueming
 */
@Configuration
@Log4j2
public class Constants {

    public final static byte IS_TRUE = 1;
    public final static byte IS_FASLE = 0;
    public static Integer FIRMWARE_FILE_MAX_SIZE;
    public static Long AVATAR_FILE_MAX_SIZE;
    public static Integer MAX_TIMEZONE;
    public static Integer MESSAGE_FILE_MAX_SIZE;

    @Value("${coros.messageFileMaxSize}")
    public void setMessageFileMaxSize(Integer messageFileMaxSize) {
        MESSAGE_FILE_MAX_SIZE = messageFileMaxSize;
    }

    @Value("${coros.maxTimezone}")
    public void setMaxTimezone(Integer maxTimezone) {
        MAX_TIMEZONE = maxTimezone;
    }

    @Value("${avatar.fileMaxSize}")
    public void setAvatarFileMaxSize(Long avatarFileMaxSize) {
        Constants.AVATAR_FILE_MAX_SIZE = avatarFileMaxSize;
    }

    @Value("${firmware.fileMaxSize}")
    public void setFirmwareFileMaxSize(Integer firmwareFileMaxSize) {
        Constants.FIRMWARE_FILE_MAX_SIZE = firmwareFileMaxSize;
    }
}
