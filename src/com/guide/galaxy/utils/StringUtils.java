package com.guide.galaxy.utils;

/**
 * @ClassName: StringUtils
 * @Description:
 * @Author: Jackson Peh
 * @CreateTime: 2020-11-28 17:49
 * @Version: 1.0
 **/
public class StringUtils {

    public static boolean isBlank(String str) {
        int strLen;
        if (str != null && (strLen = str.length()) != 0) {
            for(int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return true;
        }
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    public static String getIndexChar(String s,int index) {
        return String.valueOf(s.charAt(index));
    }

}
