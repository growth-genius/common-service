package com.gg.commonservice.enums;

/**
 * Enum 을 json 타입으로 변환
 *
 * @author leesg
 */
public class EnumMapperValue {

    private final String code;
    private final String title;
    private final boolean defaultValue;

    public EnumMapperValue(EnumMapperType enumMapperType) {
        code = enumMapperType.getCode();
        title = enumMapperType.getTitle();
        defaultValue = enumMapperType.isDefault();
    }

    public String getCode() {return code;}

    public String getTitle() {return title;}

    public boolean isDefault() {return defaultValue;}

    @Override
    public String toString() {
        return "{" + "code = '" + code + '\'' + ", title='" + title + '\'' + ", default='" + defaultValue + '\'' + "}";
    }

}
