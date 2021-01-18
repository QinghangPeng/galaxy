package com.guide.galaxy.error;

/**
 * @ClassName: GlobalErrors
 * @Description:
 * @Author: Jackson Peh
 * @CreateTime: 2020-11-28 17:55
 * @Version: 1.0
 **/
public enum GlobalErrors {

    /**
     *
     */
    UNKNOWN_COMMAND("unknown this command"),
    ERROR_CBINATION_COMMAND("error combination command"),
    UNKNOWN_SYMBOL("unknown this symbol: "),
    INCOMPATIBLE_RULES("symbol incompatible rules"),
    ERROR_QUESTION("I have no idea what you are talking about");

    private String value;

    GlobalErrors(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
