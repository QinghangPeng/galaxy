package com.guide.galaxy.rule;

import com.guide.galaxy.enums.Symbols;
import com.guide.galaxy.error.GlobalErrors;
import com.guide.galaxy.error.GlobalException;
import com.guide.galaxy.utils.StringUtils;

import java.util.*;
import java.util.function.Consumer;

/**
 * @ClassName: RuleToCalculate
 * @Description:
 * @Author: Jackson Peh
 * @CreateTime: 2020-11-28 19:15
 * @Version: 1.0
 **/
public class RuleToCalculate {

    private static final String TIMES3 = "3t";
    private static final String TIMES1 = "1t";
    private static final int MAX_REPEAT_3 = 3;
    private static final int MAX_REPEAT_1 = 1;

    /**
     * @param map
     * @param symbols
     * @return
     * @Description:
     * Numbers are formed by combining symbols together and adding the values. For example, MMVI is 1000 + 1000 + 5 + 1 = 2006.
     * Generally, symbols are placed in order of value, starting with the largest values. When smaller values precede larger values,
     * the smaller values are subtracted from the larger values, and the result is added to the total.
     * For example MCMXLIV = 1000 + (1000 − 100) + (50 − 10) + (5 − 1) = 1944.
     *
     * The symbols "I", "X", "C", and "M" can be repeated three times in succession, but no more.
     * (They may appear four times if the third and fourth are separated by a smaller value, such as XXXIX.) "D", "L", and "V" can never be repeated.
     * "I" can be subtracted from "V" and "X" only. "X" can be subtracted from "L" and "C" only.
     * "C" can be subtracted from "D" and "M" only. "V", "L", and "D" can never be subtracted.
     * Only one small-value symbol may be subtracted from any large-value symbol.
     * A number written in [16]Arabic numerals can be broken into digits.
     * For example, 1903 is composed of 1, 9, 0, and 3. To write the Roman numeral, each of the non-zero digits should be treated separately.
     * Inthe above example, 1,000 = M, 900 = CM, and 3 = III. Therefore, 1903 = MCMIII.
     *
     * 思路:
     * MCMXLIV = 1000 + (1000 - 100) + (50 - 10) + (5 - 1)
     * 倒序 ====> VILXMCM = 5 - 1 + 50 - 10 + 1000 - 100 + 1000
     *
     */
    public static Long calCombinationValue(Map<String,String> map,List<String> symbols) {
        if (!Optional.ofNullable(symbols).isPresent()) {
            throw new GlobalException(GlobalErrors.ERROR_CBINATION_COMMAND);
        }
        Collections.reverse(symbols);
        Long total = 0L;
        Long lastNum = 0L;
        Map<String, Integer> repeat3 = Symbols.getRepeatCount(TIMES3);
        Map<String, Integer> repeat1 = Symbols.getRepeatCount(TIMES1);
        for (String s : symbols) {
            String syb = map.get(s);
            if (StringUtils.isBlank(syb)) {
                throw new GlobalException(GlobalErrors.UNKNOWN_SYMBOL,s);
            }
            if (Symbols.getSingleSymbol(syb) == null) {
                throw new GlobalException(GlobalErrors.UNKNOWN_SYMBOL,s);
            }

            if (Symbols.getRulesByType(TIMES3).contains(syb) && repeat3.get(syb) <= MAX_REPEAT_3) {
                //重复三次
                total = calTotal(total,Symbols.getSingleSymbol(syb),lastNum);
                lastNum = Symbols.getSingleSymbol(syb);
                repeat3.put(syb,repeat3.get(syb) + 1);
            } else if (Symbols.getRulesByType(TIMES1).contains(syb) && repeat1.get(syb) <= MAX_REPEAT_1) {
                //重复一次
                total = calTotal(total,Symbols.getSingleSymbol(syb),lastNum);
                lastNum = Symbols.getSingleSymbol(syb);
                repeat1.put(syb,repeat1.get(syb) + 1);
            } else {
                throw new GlobalException(GlobalErrors.INCOMPATIBLE_RULES);
            }
        }
        return total;
    }

    private static Long calTotal(Long total,Long currentValue,Long lastValue) {
        if (currentValue < lastValue) {
            total -= currentValue;
        } else {
            total += currentValue;
        }
        return total;
    }


}
