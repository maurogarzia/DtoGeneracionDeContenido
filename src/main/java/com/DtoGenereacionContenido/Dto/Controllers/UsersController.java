package com.DtoGenereacionContenido.Dto.Controllers;

import com.DtoGenereacionContenido.Dto.Entities.Users;
import com.DtoGenereacionContenido.Dto.Services.UsersService;
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
    public ResponseEntity<List<Users>> getAll(){
        try{
            List<Users> users =usersService.findAll();
            return ResponseEntity.ok(users);
        }catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getById(@PathVariable Long id){
        try{
            Users user = usersService.findById(id);
            return ResponseEntity.ok(user);
        }catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<Users> create(@RequestBody Users newUser){
        try{
            Users createdUser = usersService.save(newUser);
            return ResponseEntity.status(201).body(createdUser);
        }catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> update(@RequestBody Users newUser, @PathVariable Long id){
        try {
            Users updatedUser = usersService.update(id, newUser);
            return ResponseEntity.ok(updatedUser);
        } catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        try {
            boolean deleted = usersService.delete(id);
            if (deleted){
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
}
