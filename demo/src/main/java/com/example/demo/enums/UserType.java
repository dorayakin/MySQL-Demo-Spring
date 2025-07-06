package com.example.demo.enums;

public enum UserType {
    ADMIN(1, "ADMIN"), GENERAL(2, "GENERAL");

    private final int code;
    private final String label;

    UserType(int code, String label) {
        this.code = code;
        this.label = label;
    }

    public int getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    // コード値からUserTypeを取得するメソッド
    public static UserType fromCode(int code) {
        for (UserType userType : UserType.values()) {
            if (userType.getCode() == code) {
                return userType;
            }
        }
        throw new IllegalArgumentException("Invalid UserType code: " + code);
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
