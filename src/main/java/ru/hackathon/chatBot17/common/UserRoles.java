package ru.hackathon.chatBot17.common;

/**
 * Describing a role model.
 * */
public enum UserRoles {
    UNK("unknown", -1),
    ADMIN("admin", 1),
    USER("user",2);

    private String name;
    private Integer code;

    UserRoles(String name, Integer code) {
        this.name = name;
        this.code = code;
    }

    public static UserRoles getByRoleId(Integer code) {
        if (code == null) {
            return UNK;
        }

        for (UserRoles role : UserRoles.values()) {
            if (role.getCode().equals(code)) {
                return role;
            }
        }

        return UNK;
    }

    public Integer getCode() {return code;}

    public String getName() {return name;}
}
