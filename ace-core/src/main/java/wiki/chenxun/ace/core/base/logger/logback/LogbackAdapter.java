package wiki.chenxun.ace.core.base.logger.logback;

import org.slf4j.LoggerFactory;
import wiki.chenxun.ace.core.base.common.AceLoggerConfig;
import wiki.chenxun.ace.core.base.logger.Logger;
import wiki.chenxun.ace.core.base.logger.LoggerAdapter;
import wiki.chenxun.ace.core.base.logger.LoggerLevel;

import java.util.Observable;

/**
 * Created by cookie on 2017/4/26.
 */
public class LogbackAdapter implements LoggerAdapter {

    private AceLoggerConfig loggerConfig;

    @Override
    public Logger getLogger(String name) {
        return new LogbackImpl(LoggerFactory.getLogger(name),this);
    }

    @Override
    public Logger getLogger(Class clz) {
        return getLogger(clz.getName());
    }

    @Override
    public void setConfigBean(AceLoggerConfig aceLoggerConfig) {
        this.loggerConfig = aceLoggerConfig;
    }

    @Override
    public void update(Observable o, Object arg) {
        this.loggerConfig = (AceLoggerConfig) arg;
    }

    public static class LogbackImpl implements Logger{

        private org.slf4j.Logger logger;

        private LogbackAdapter logbackAdapter;

        public LogbackImpl(org.slf4j.Logger logger,LogbackAdapter adapter){
            this.logger = logger;
            this.logbackAdapter = adapter;
        }

        @Override
        public String getName() {
            return logger.getName();
        }

        @Override
        public void trace(String var1) {
            if(isTraceEnabled()) {
                logger.trace(var1);
            }
        }

        @Override
        public void trace(String var1, Object[] objects) {
            if(isTraceEnabled()){
                logger.trace(var1);
            }
        }

        @Override
        public boolean isTraceEnabled() {
            return logbackAdapter.loggerConfig.getLevel() <= LoggerLevel.TRACE.getLevel();
        }

        @Override
        public void debug(String var1) {
            if(isDebugEnabled()){
                logger.debug(var1);
            }
        }

        @Override
        public void debug(String var1, Object[] objects) {
            if(isDebugEnabled()){
                logger.debug(var1);
            }
        }

        @Override
        public boolean isDebugEnabled() {
            return logbackAdapter.loggerConfig.getLevel() <= LoggerLevel.DEBUG.getLevel();
        }

        @Override
        public void info(String var1) {
            if(isInfoEnabled()){
                logger.info(var1);
            }
        }

        @Override
        public void info(String var1, Object[] objects) {
            if(isInfoEnabled()){
                logger.info(var1);
            }
        }

        @Override
        public boolean isInfoEnabled() {
            return logbackAdapter.loggerConfig.getLevel() <= LoggerLevel.INFO.getLevel();
        }

        @Override
        public void warn(String var1) {
            if(isWarnEnabled()){
                logger.warn(var1);
            }
        }

        @Override
        public void warn(String var1, Object[] objects) {
            if(isWarnEnabled()){
                logger.warn(var1);
            }
        }

        @Override
        public boolean isWarnEnabled() {
            return logbackAdapter.loggerConfig.getLevel() <= LoggerLevel.WARN.getLevel();
        }

        @Override
        public void error(String var1) {
            if(isErrorEnabled()){
                logger.error(var1);
            }
        }

        @Override
        public void error(String var1, Object[] objects) {
            if(isErrorEnabled()){
                logger.error(var1);
            }
        }

        @Override
        public boolean isErrorEnabled() {
            return logbackAdapter.loggerConfig.getLevel() <= LoggerLevel.ERROR.getLevel();
        }
    }
}
