package com.guide.galaxy.process;

import com.guide.galaxy.commands.BaseCommond;
import com.guide.galaxy.commands.CombinationSymbolCommand;
import com.guide.galaxy.commands.QuestionCommand;
import com.guide.galaxy.commands.SymbolCommand;
import com.guide.galaxy.enums.Symbols;
import com.guide.galaxy.error.GlobalErrors;
import com.guide.galaxy.error.GlobalException;
import com.guide.galaxy.utils.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: MainProcess
 * @Description:
 * @Author: Jackson Peh
 * @CreateTime: 2020-11-28 17:24
 * @Version: 1.0
 **/
public class MainProcess {

    private static String END = "CREDITS";

    private Map<String,String> map = new HashMap<>();

    private Map<String,Double> cbinationMap = new HashMap<>();

    /**
     *  主处理
     * @param list
     */
    public void handle(List<String> list) {
        //对所有的命令进行分类
        list.forEach(s -> {
            if (StringUtils.isBlank(s)) {
                throw new GlobalException(GlobalErrors.UNKNOWN_COMMAND);
            }
            String tcommand = s.trim().toUpperCase();
            BaseCommond commond = matchCommand(tcommand);
            commond.excuteCommand(map,cbinationMap,tcommand);
        });
    }

    /**
     *  对命令进行分类
     * @param tcommand
     * @return
     */
    private BaseCommond matchCommand(String tcommand) {
        //like glob is I
        if (Symbols.getCurrencySymbols().containsKey(StringUtils.getIndexChar(tcommand,tcommand.length() - 1))
                && StringUtils.isBlank(StringUtils.getIndexChar(tcommand,tcommand.length() - 2))) {
            return new SymbolCommand();
        }
        //like glob glob Silver is 34 Credits
        if (tcommand.endsWith(END)) {
            return new CombinationSymbolCommand();
        }
        //like how much is pish tegj glob glob ?
        if (tcommand.endsWith("?")) {
            return new QuestionCommand();
        }
        throw new GlobalException(GlobalErrors.UNKNOWN_COMMAND);
    }
}
