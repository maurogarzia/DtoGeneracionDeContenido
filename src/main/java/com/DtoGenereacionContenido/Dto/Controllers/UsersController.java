package com.DtoGenereacionContenido.Dto.Controllers;

import com.DtoGenereacionContenido.Dto.Entities.Users;
import com.DtoGenereacionContenido.Dto.Services.UsersService;
import com.DtoGenereacionContenido.Dto.dtos.UserCreateDTO;
import com.DtoGenereacionContenido.Dto.dtos.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/practice-dto/users")
public class UsersController {
    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAll() {
        try {
            return ResponseEntity.ok(usersService.findAll());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(usersService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody UserCreateDTO dto) {
        try {
            UserDTO created = usersService.save(dto);
            return ResponseEntity.status(201).body(created);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable Long id, @RequestBody UserCreateDTO dto) {
        try {
            UserDTO updated = usersService.update(id, dto);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            boolean deleted = usersService.delete(id);
            return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
