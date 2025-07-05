package com.example.demo.enums;

public enum UserType {
    ADMIN(1, "ADMIN"), GENERAL(2, "GENERAL");

    private final int code;
    private final String label;

    UserType(int code, String label) {
        this.code = code;
        this.label = label;
    }

    @Override
    public String toString() {
        return switch (this) {
            case ADMIN -> "ADMIN";
            case GENERAL -> "GENERAL";
            default -> null;
        };
    }
}
