package com.DtoGenereacionContenido.Dto.dtos;

public class PostDTO {
    private Long id;
    private String title;
    private String content;
    private String userName;


    public PostDTO(Long id, String title, String content, String userName) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userName = userName;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getUserName() {
        return userName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

