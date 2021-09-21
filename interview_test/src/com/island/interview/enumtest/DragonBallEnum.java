package com.island.interview.enumtest;

/**
 * @author island
 * @version 1.0 2021/9/6 10:43
 */
public enum  DragonBallEnum {

    ONE(1,"赤"),TWO(2,"橙"),Three(3,"黄"),
    Four(4,"绿"),Five(5,"青"),Six(6,"蓝"),
    Seven(7,"紫");

    private Integer code;
    private String codeValue;

    DragonBallEnum(Integer code, String codeValue) {
        this.code = code;
        this.codeValue = codeValue;
    }

    public Integer getCode() {
        return code;
    }

    public String getCodeValue() {
        return codeValue;
    }

    public static DragonBallEnum returnEnum(int index){
        DragonBallEnum[] values = DragonBallEnum.values();

        for (DragonBallEnum value : values) {
            if (value.getCode() == index){
                return value;
            }
        }

        return null;
    }

}
