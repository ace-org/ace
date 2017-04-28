package wiki.chenxun.ace.core.base.logger;

/**
 * Created by cookie on 2017/4/25.
 */
public enum LoggerLevel {
    OFF(0),
    TRACE(1000),
    DEBUG(2000),
    INFO(3000),
    WARN(4000),
    ERROR(5000),
    ALL(Integer.MAX_VALUE);
    private int level;
    LoggerLevel(int level){
        this.level = level;
    }
    public int getLevel(){
        return level;
    }

}
