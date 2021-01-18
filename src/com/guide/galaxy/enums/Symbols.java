package com.guide.galaxy.enums;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName: Symbols
 * @Description:
 * @Author: Jackson Peh
 * @CreateTime: 2020-11-28 15:14
 * @Version: 1.0
 **/
public enum Symbols {

    /**
     *
     */
    I("I",1L,"3t"),
    V("V",5L,"1t"),
    X("X",10L,"3t"),
    L("L",50L,"1t"),
    C("C",100L,"3t"),
    D("D",500L,"1t"),
    M("M",1000L,"3t"),;

    private String symbol;
    private Long value;
    private String type;

    Symbols(String symbol, Long value,String type) {
        this.symbol = symbol;
        this.value = value;
        this.type = type;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     *  获取钱币对应值关系集合
     * @return
     */
    public static Map<String,Long> getCurrencySymbols() {
        Map<String, Long> map = Arrays.asList(Symbols.values())
                .stream()
                .collect(Collectors.toMap(Symbols::getSymbol, Symbols::getValue));
        return map;
    }

    /**
     *  根据符号获取单种钱币值
     * @param s
     * @return
     */
    public static Long getSingleSymbol(String s) {
        for (Symbols sb : Symbols.values()) {
            if (sb.getSymbol().equals(s.toUpperCase())) {
                return sb.getValue();
            }
        }
        return null;
    }

    /**
     *  分组获取可重复次数的符号
     * @param type
     * @return
     */
    public static List<String> getRulesByType(String type) {
        List<String> list = Arrays.asList(Symbols.values())
                .stream().filter(x -> x.getType().equals(type))
                .map(s -> s.getSymbol())
                .collect(Collectors.toList());
        return list;
    }

    /**
     *  获取每种符号重复值
     * @param type
     * @return
     */
    public static Map<String,Integer> getRepeatCount(String type) {
        List<String> list = getRulesByType(type);
        Map<String, Integer> map = list.stream().collect(Collectors.toMap(s -> s, s -> 0));
        return map;
    }
}
