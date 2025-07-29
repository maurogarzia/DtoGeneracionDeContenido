package com.DtoGenereacionContenido.Dto.dtos;

public class UserCreateDTO {
    private String name;
    private String email;

    public UserCreateDTO() {}

    public UserCreateDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters y Setters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
