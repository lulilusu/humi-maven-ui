package com.hm.utils;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class log {

    // 用于存类名和logger对象
    private static Map<String, Logger> loggerMap = new HashMap<String, Logger>();

    /**
     * 获取第一次调用logger类
     *
     * @return
     */
    private static String getCalssName() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        StackTraceElement ste = stackTrace[2];
        return ste.getClassName();
    }

    /**
     * 根据类名获取logger对象
     *
     * @param className
     * @return
     */
    private static Logger getLogger(String className) {
        Logger log = null;
        if (loggerMap.containsKey(className)) {
            log = loggerMap.get(className);
        } else {
            try {
                log = Logger.getLogger(Class.forName(className));
                loggerMap.put(className, log);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return log;
    }

    public static void deBug(Object message) {
        Logger logger = getLogger(getCalssName());
        if (logger.isDebugEnabled()) {
            logger.debug(message);
        }
    }

    public static void deBug(String tag, Object message) {
        Logger logger = getLogger(getCalssName());
        if (logger.isDebugEnabled()) {
            logger.debug(new StringBuffer().append("[").append(tag).append("]").append(message).toString());
        }
    }

    public static void info(Object message) {
        Logger logger = getLogger(getCalssName());
        if (logger.isInfoEnabled()) {
            logger.info(message);
        }
    }

    public static void info(String tag, Object message) {
        Logger logger = getLogger(getCalssName());
        if (logger.isInfoEnabled()) {
            logger.info(new StringBuffer().append("[").append(tag).append("]").append(message).toString());
        }
    }

    public static void warn(Object message) {
        Logger logger = getLogger(getCalssName());
        logger.warn(message);
    }

    public static void warn(String tag, Object message) {
        Logger logger = getLogger(getCalssName());
        logger.warn(new StringBuffer().append("[").append(tag).append("]").append(message).toString());
    }

    public static void error(Object message) {
        Logger logger = getLogger(getCalssName());
        logger.error(message);
    }

    public static void error(String tag, Object message) {
        Logger logger = getLogger(getCalssName());
        logger.error(new StringBuffer().append("[").append(tag).append("]").append(message).toString());
    }
}
