package ru.shop.jsonScheme;

public class Error {
    private String description;
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public Error setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Error setDescription(String description) {
        this.description = description;
        return this;
    }
}
