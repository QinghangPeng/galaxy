package com.guide.galaxy.commands;

import com.guide.galaxy.rule.RuleToCalculate;
import com.guide.galaxy.utils.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: CombinationSymbolCommand
 * @Description:
 * @Author: Jackson Peh
 * @CreateTime: 2020-11-28 18:25
 * @Version: 1.0
 **/
public class CombinationSymbolCommand implements BaseCommond{

    @Override
    public void excuteCommand(Map<String,String> map, Map<String,Double> cbinationMap,String command) {
        String[] words = command.split(" ");
        List<String> symbols = new ArrayList<>();
        int i = 0;
        while (StringUtils.isNotBlank(map.get(words[i]))) {
            symbols.add(words[i]);
            i ++;
        }

        //这里加上结果是为了更加灵活的输入不同的结果
        String combinationSymbolName = words[i] + "@" + words[words.length - 1];
        Long combinationValue = Long.valueOf(words[i + 2]);
        Long count = RuleToCalculate.calCombinationValue(map,symbols);
        if (cbinationMap.get(combinationSymbolName) == null) {
            cbinationMap.put(combinationSymbolName,rightSubtract(combinationValue,count));
//            System.out.println("cbinationMap key:" + combinationSymbolName + " value:" + combinationValue / count);
        }
    }

    private Double rightSubtract(Long num1,Long num2) {
        return BigDecimal.valueOf(num1).divide(BigDecimal.valueOf(num2)).setScale(1).doubleValue();
    }
}
