package com.guide.galaxy;

import com.guide.galaxy.error.GlobalException;
import com.guide.galaxy.process.MainProcess;
import com.guide.galaxy.utils.FileUtil;

import java.io.*;
import java.util.List;

/**
 * @ClassName: Application
 * @Description:
 * @Author: Jackson Peh
 * @CreateTime: 2020-11-28 15:12
 * @Version: 1.0
 **/
public class Application {

    private static String PATH = "resources" + File.separator + "input";

    public static void main(String[] args) {
        try {
            //read file
            List<String> commands = FileUtil.readFile(PATH);
            System.out.println("============ input content ============");
            commands.forEach(s -> System.out.println(s));
            //analysis datas
            System.out.println("\n============ output content ============");
            MainProcess process = new MainProcess();
            process.handle(commands);
        } catch (GlobalException e) {
            System.out.println(e.getMessage());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


}
