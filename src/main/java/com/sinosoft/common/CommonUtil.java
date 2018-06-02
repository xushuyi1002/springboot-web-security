package com.sinosoft.common;

/**
 * 工具类
 */
public class CommonUtil {

    /**
     * 判断一个对象是否为空
     *
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj) {
        if (("").equals(obj) || null == obj || "null".equals(obj) || obj.equals(null)) {
            return true;
        }
        return false;
    }

}
