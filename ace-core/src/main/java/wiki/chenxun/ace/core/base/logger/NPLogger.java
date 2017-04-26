package wiki.chenxun.ace.core.base.logger;

import wiki.chenxun.ace.core.base.common.AceLoggerConfig;

import java.util.Observable;

/**
 * Created by cookie on 2017/4/26.
 */
public class NPLogger implements Logger , LoggerAdapter {

    @Override
    public void setConfigBean(AceLoggerConfig aceLoggerConfig) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void trace(String var1) {

    }

    @Override
    public void trace(String var1, Object[] objects) {

    }

    @Override
    public boolean isTraceEnabled() {
        return false;
    }

    @Override
    public void debug(String var1) {

    }

    @Override
    public void debug(String var1, Object[] objects) {

    }

    @Override
    public boolean isDebugEnabled() {
        return false;
    }

    @Override
    public void info(String var1) {

    }

    @Override
    public void info(String var1, Object[] objects) {

    }

    @Override
    public boolean isInfoEnabled() {
        return false;
    }

    @Override
    public void warn(String var1) {

    }

    @Override
    public void warn(String var1, Object[] objects) {

    }

    @Override
    public boolean isWarnEnabled() {
        return false;
    }

    @Override
    public void error(String var1) {

    }

    @Override
    public void error(String var1, Object[] objects) {

    }

    @Override
    public boolean isErrorEnabled() {
        return false;
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    @Override
    public Logger getLogger(String name) {
        return new NPLogger();
    }

    @Override
    public Logger getLogger(Class clz) {
        return new NPLogger();
    }
}
