package com.guide.galaxy.enums;

/**
 * @ClassName: Questions
 * @Description:
 * @Author: Jackson Peh
 * @CreateTime: 2020-11-28 23:54
 * @Version: 1.0
 **/
public enum Questions {

    /**
     *
     */
    HOW_MUCH("HOW MUCH IS "),
    HOW_MANY("HOW MANY "),;

    private String type;

    Questions(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
