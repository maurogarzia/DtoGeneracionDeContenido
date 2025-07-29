package com.DtoGenereacionContenido.Dto.dtos;


public class PostCreateDTO {
    private String title;
    private String content;
    private Long userId;

    public PostCreateDTO() {}

    public PostCreateDTO(String title, String content, Long userId) {
        this.title = title;
        this.content = content;
        this.userId = userId;
    }

    // Getters y Setters
    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Long getUserId() {
        return userId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
