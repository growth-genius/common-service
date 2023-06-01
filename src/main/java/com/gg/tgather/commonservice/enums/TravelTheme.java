package com.gg.tgather.commonservice.enums;

public enum TravelTheme implements EnumMapperType {

    FOOD("먹방", false),
    HEALING("힐링", true),
    ACTIVITY("액티비티", false),
    ;

    private final String theme;
    private final boolean active;

    TravelTheme(String theme, boolean active) {
        this.theme = theme;
        this.active = active;
    }

    @Override
    public String getCode() {
        return name();
    }

    @Override
    public String getTitle() {
        return this.theme;
    }

    @Override
    public boolean isDefault() {
        return this.active;
    }
}
