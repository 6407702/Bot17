package ru.hackathon.chatBot17.common;

/**
 * Type of commands for processing
 * */
public enum CommandTypes {
    UNK("unknown", -1),
    SSH("ssh", 1),
    JNK("jenkins",2),
    GIT("git",3);

    private String name;
    private Integer code;

    CommandTypes(String name, Integer code) {
        this.name = name;
        this.code = code;
    }

    public static CommandTypes getTypeByName(String name) {
        if (name == null || name.isEmpty()) {
            return UNK;
        }

        for (CommandTypes type : CommandTypes.values()) {
            if (type.getName().equals(name)) {
                return type;
            }
        }

        return UNK;
    }
    public Integer getCode() {return code;}

    public String getName() {return name;}
}
