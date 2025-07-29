package com.DtoGenereacionContenido.Dto.Controllers;

import com.DtoGenereacionContenido.Dto.Entities.Posts;
import com.DtoGenereacionContenido.Dto.Services.PostsService;
import com.DtoGenereacionContenido.Dto.dtos.PostCreateDTO;
import com.DtoGenereacionContenido.Dto.dtos.PostDTO;
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
    public ResponseEntity<List<PostDTO>> getAll() {
        try {
            return ResponseEntity.ok(postsService.findAll());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(postsService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<PostDTO> create(@RequestBody PostCreateDTO dto) {
        try {
            PostDTO created = postsService.save(dto);
            return ResponseEntity.status(201).body(created);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDTO> update(@PathVariable Long id, @RequestBody PostCreateDTO dto) {
        try {
            PostDTO updated = postsService.update(id, dto);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            boolean deleted = postsService.delete(id);
            return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
