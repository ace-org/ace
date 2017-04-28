package wiki.chenxun.ace.core.base.logger;

/**
 * Created by cookie on 2017/4/25.
 */
public interface Logger {

    String getName();

    void trace(String var1);

    void trace(String var1, Object[] objects);

    boolean isTraceEnabled();

    void debug(String var1);

    void debug(String var1, Object[] objects);

    boolean isDebugEnabled();

    void info(String var1);

    void info(String var1, Object[] objects);

    boolean isInfoEnabled();

    void warn(String var1);

    void warn(String var1, Object[] objects);

    boolean isWarnEnabled();

    void error(String var1);

    void error(String var1, Object[] objects);

    boolean isErrorEnabled();
}
