package com.javaweb.enums;

import java.util.Map;
import java.util.TreeMap;

public enum RoleOption {
    USER("Người dùng"),
    STAFF("Nhân viên");

    private final String role;

    RoleOption(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public static Map<String, String> type() {
        Map<String, String> options = new TreeMap<>();
        for (RoleOption roleOption : RoleOption.values()) {
            options.put(roleOption.name(), roleOption.getRole());
        }
        return options;
    }
}
