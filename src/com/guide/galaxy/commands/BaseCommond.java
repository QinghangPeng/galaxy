package com.guide.galaxy.commands;

import java.util.Map;

/**
 * @ClassName: BaseCommond
 * @Description:
 * @Author: Jackson Peh
 * @CreateTime: 2020-11-28 17:43
 * @Version: 1.0
 **/
public interface BaseCommond {

    void excuteCommand(Map<String,String> map,Map<String,Double> cbinationMap,String command);

}
