package com.DtoGenereacionContenido.Dto.dtos;

import java.util.List;

public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private List<String> postTitles;

    public UserDTO() {}

    public UserDTO(Long id, String name, String email, List<String> postTitles) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.postTitles = postTitles;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getPostTitles() {
        return postTitles;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPostTitles(List<String> postTitles) {
        this.postTitles = postTitles;
    }
}
