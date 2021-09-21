package com.island.interview.enumtest;

/**
 * @author island
 * @version 1.0 2021/9/6 10:02
 */

public enum CountryEnum {

    ONE(1,"齐"),TWO(2,"楚"),Three(3,"燕"),
    Four(4,"赵"),Five(5,"魏"),Six(6,"韩");

    private Integer code;
    private String codeValue;

    CountryEnum(Integer code, String codeValue) {
        this.code = code;
        this.codeValue = codeValue;
    }

    public Integer getCode() {
        return code;
    }

    public String getCodeValue() {
        return codeValue;
    }

    public static CountryEnum returnEnum(int index){
        CountryEnum[] values = CountryEnum.values();

        for (CountryEnum value : values) {
            if (value.getCode() == index){
                return value;
            }
        }

        return null;
    }
}
