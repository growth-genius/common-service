package com.gg.tgather.commonservice.enums;


public enum AccountRole implements EnumMapperType {

    ADMIN("관리자", false),  // 관리자
    LEADER("모임장", false),
    USER("사용자", true),
    ;

    private final String role;
    private final boolean active;

    AccountRole(String role, boolean active) {
        this.role = role;
        this.active = active;
    }

    @Override
    public String getCode() {
        return this.name();
    }

    @Override
    public String getTitle() {
        return this.role;
    }

    @Override
    public boolean isDefault() {
        return this.active;
    }
}
