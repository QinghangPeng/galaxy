package com.guide.galaxy.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: FileUtil
 * @Description:
 * @Author: Jackson Peh
 * @CreateTime: 2020-11-28 16:15
 * @Version: 1.0
 **/
public class FileUtil {

    /**
     *  读取文件内容并组装
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static List<String> readFile(String path) throws FileNotFoundException,IOException{
        FileInputStream fis = new FileInputStream(path);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
        List<String> list = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            list.add(line);
        }
        return list;
    }

}
