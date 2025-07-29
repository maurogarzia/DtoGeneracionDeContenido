package com.DtoGenereacionContenido.Dto.Controllers;

import com.DtoGenereacionContenido.Dto.Entities.Posts;
import com.DtoGenereacionContenido.Dto.Services.PostsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/practice-dto/posts")
public class PostsController {
    private final PostsService postsService;

    public PostsController(PostsService postsService) {
        this.postsService = postsService;
    }


    @GetMapping
    public ResponseEntity<List<Posts>> getAll() {
        try {
            List<Posts> posts = postsService.findAll();
            return ResponseEntity.ok(posts);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Posts> getById(@PathVariable Long id) {
        try {
            Posts post = postsService.findById(id);
            return ResponseEntity.ok(post);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }


    @PostMapping
    public ResponseEntity<Posts> create(@RequestBody Posts newPost) {
        try {
            Posts createdPost = postsService.save(newPost);
            return ResponseEntity.status(201).body(createdPost);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Posts> update(@PathVariable Long id, @RequestBody Posts newPost) {
        try {
            Posts updatedPost = postsService.update(id, newPost);
            return ResponseEntity.ok(updatedPost);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            boolean deleted = postsService.delete(id);
            if (deleted) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
