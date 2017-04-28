package wiki.chenxun.ace.core.base.logger;

import wiki.chenxun.ace.core.base.annotations.Spi;
import wiki.chenxun.ace.core.base.common.AceLoggerConfig;
import wiki.chenxun.ace.core.base.config.ConfigBeanAware;

/**
 * Created by cookie on 2017/4/26.
 */
@Spi("logback")
public interface LoggerAdapter extends ConfigBeanAware<AceLoggerConfig> {
    Logger getLogger(String name);
    Logger getLogger(Class clz);
}
