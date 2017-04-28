package wiki.chenxun.ace.core.base.common;

import lombok.Data;
import wiki.chenxun.ace.core.base.annotations.ConfigBean;
import wiki.chenxun.ace.core.base.logger.LoggerLevel;

/**
 * Created by cookie on 2017/4/25.
 */
@Data
@ConfigBean(AceLoggerConfig.PREFIX)
public class AceLoggerConfig {
    public static final String PREFIX = "ace.logger";

    private int level = LoggerLevel.OFF.getLevel();

    public void setLevel(String levelString){
        LoggerLevel[] loggerLevels = LoggerLevel.values();
        for(LoggerLevel loggerLevel : loggerLevels){
            if(loggerLevel.toString().equalsIgnoreCase(levelString)){
                level = loggerLevel.getLevel();
            }
        }
    }

}
