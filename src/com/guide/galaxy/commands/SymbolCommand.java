package com.guide.galaxy.commands;

import com.guide.galaxy.commands.BaseCommond;
import com.guide.galaxy.utils.StringUtils;

import java.util.Map;

/**
 * @ClassName: SymbolCommand
 * @Description:
 * @Author: Jackson Peh
 * @CreateTime: 2020-11-28 18:16
 * @Version: 1.0
 **/
public class SymbolCommand implements BaseCommond {

    @Override
    public void excuteCommand(Map<String,String> map, Map<String,Double> cbinationMap,String command) {
        String[] words = command.split(" ");
        if (StringUtils.isBlank(map.get(words[0]))) {
            map.put(words[0],words[2]);
//            System.out.println("map key:" + words[0] + " value:" + words[2]);
        }
    }
}
