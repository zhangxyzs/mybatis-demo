package com.zhangxy.mybatisdemo.handler.mybatis;

public enum PersonTypeEnum implements BaseEnum<PersonTypeEnum, String> {

    STUDENT("1", "学生"),
    TEACHER("2", "老师");

    private String value;
    private String displayName;

    private PersonTypeEnum(String value, String displayName) {
        this.value = value;
        this.displayName = displayName;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String getDisplayName() {
        for(PersonTypeEnum personTypeEnum:PersonTypeEnum.values()){
            if(value.equals(personTypeEnum.getValue())){
                return personTypeEnum.getDisplayName();
            }
        }
        return null;
    }
    public static PersonTypeEnum getEnum(String value){
        for(PersonTypeEnum personTypeEnum:PersonTypeEnum.values()){
            if(value.equals(personTypeEnum.getValue())){
                return personTypeEnum;
            }
        }
        return null;
    }
}
