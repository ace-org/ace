package wiki.chenxun.ace.core.base.logger;

import wiki.chenxun.ace.core.base.common.ExtendLoader;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by cookie on 2017/4/26.
 */
public class LoggerFactory {

    private static LoggerAdapter loggerAdapter;

    public static Logger getLogger(String name){
        if(loggerAdapter == null){
            synchronized (LoggerFactory.class) {
                if(loggerAdapter == null) {
                    loggerAdapter = ExtendLoader.getExtendLoader(LoggerAdapter.class).getExtension("");
                    if (loggerAdapter == null) {
                        Set<String> extensionKeySet = getLoggerAdapterCandidateKey();
                        for (String extensionName : extensionKeySet) {
                            try {
                                loggerAdapter = ExtendLoader.getExtendLoader(LoggerAdapter.class).getExtension(extensionName);
                                Logger logger = loggerAdapter.getLogger(LoggerFactory.class);
                                logger.info("using ace loggerAdapter "+loggerAdapter.getClass().toString());
                                break;
                            } catch (Throwable e) {
                            }
                        }
                    }else{
                        Logger logger = loggerAdapter.getLogger(LoggerFactory.class);
                        logger.info("using ace loggerAdapter "+loggerAdapter.getClass().toString());
                    }
                }
            }
        }
        return loggerAdapter.getLogger(name);
    }

    public static void setLoggerAdapter(String adapter){
        loggerAdapter = ExtendLoader.getExtendLoader(LoggerAdapter.class).getExtension(adapter);
        Logger logger = loggerAdapter.getLogger(LoggerFactory.class);
        logger.info("using ace loggerAdapter "+loggerAdapter.getClass().toString());
    }


    public static Logger getLogger(Class clz){
        return getLogger(clz.getName());
    }

    public static Set<String> getLoggerAdapterCandidateKey(){
        ExtendLoader<LoggerAdapter> extendLoader = ExtendLoader.getExtendLoader(LoggerAdapter.class);
        try {
            Field candidateField = extendLoader.getClass().getDeclaredField("extendClasses");
            candidateField.setAccessible(true);
            ConcurrentHashMap<String, Class> candidateMap = (ConcurrentHashMap<String, Class>) candidateField.get(extendLoader);
            return candidateMap.keySet();
        } catch (NoSuchFieldException e) {
            return Collections.emptySet();
        } catch (IllegalAccessException e) {
            return Collections.emptySet();
        }
    }
}
