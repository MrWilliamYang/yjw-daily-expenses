package com.yjw.interview.utils;

import org.slf4j.MDC;

/**
 * @author WindsYan
 * @version $Id: hello, v 0.1 2018/6/1 10:54 WindsYan Exp $
 */
public class MdcUtil {

    public static void setCallerUserMethod(String caller, String user, String method){
        MDC.clear();
        MDC.put("caller", caller);
        MDC.put("user", user);
        MDC.put("method", method);
    }
}
