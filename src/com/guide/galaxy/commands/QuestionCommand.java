package com.guide.galaxy.commands;

import com.guide.galaxy.commands.BaseCommond;
import com.guide.galaxy.enums.Questions;
import com.guide.galaxy.error.GlobalErrors;
import com.guide.galaxy.error.GlobalException;
import com.guide.galaxy.rule.RuleToCalculate;
import com.guide.galaxy.utils.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName: QuestionCommand
 * @Description:
 * @Author: Jackson Peh
 * @CreateTime: 2020-11-28 18:26
 * @Version: 1.0
 **/
public class QuestionCommand implements BaseCommond {

    @Override
    public void excuteCommand(Map<String,String> map, Map<String,Double> cbinationMap,String command) {
        //对问题分类
        command = command.replace("?","");
        if (command.startsWith(Questions.HOW_MUCH.getType())) {
            answerHowmuch(map,checkQuestion(command,Questions.HOW_MUCH.getType()));
        } else if (command.startsWith(Questions.HOW_MANY.getType())) {
            answerHowmany(map,cbinationMap,checkQuestion(command,Questions.HOW_MANY.getType()));
        } else {
            throw new GlobalException(GlobalErrors.ERROR_QUESTION);
        }
    }

    private void answerHowmuch(Map<String,String> map,List<String> list) {
        Long count = RuleToCalculate.calCombinationValue(map, list);
        Collections.reverse(list);
        System.out.println(buildAnswer(String.join(" ",list),count,""));
    }

    private void answerHowmany(Map<String,String> map,Map<String,Double> cbinationMap,List<String> list) {
        String cbKey = list.get(list.size() - 1) + "@" + list.get(0);
        if (cbinationMap.get(cbKey) == null) {
            throw new GlobalException(GlobalErrors.ERROR_QUESTION);
        }
        Double cbCount = cbinationMap.get(cbKey);
        List<String> symbols = list.stream().filter(x -> StringUtils.isNotBlank(map.get(x))).collect(Collectors.toList());
        Long symbolCount = RuleToCalculate.calCombinationValue(map, symbols);
        Collections.reverse(symbols);
        System.out.println(buildAnswer(String.join(" ",symbols),(long) (cbCount * symbolCount),list.get(0)));
    }

    private String buildAnswer(String start,Long count,String end) {
        return start + " IS " + count + " " + end;
    }

    private List<String> checkQuestion(String command,String type) {
        String[] split = command.split(type);
        if (split.length != 2) {
            throw new GlobalException(GlobalErrors.ERROR_QUESTION);
        }
        List<String> list = Arrays.asList(split[1].split(" ")).stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
        return list;
    }
}
