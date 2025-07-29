package com.DtoGenereacionContenido.Dto.Services;

import com.DtoGenereacionContenido.Dto.Entities.Users;
import com.DtoGenereacionContenido.Dto.Repositories.UsersRepository;
import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Transactional
    public List<Users> findAll() throws Exception {
        try{
            return usersRepository.findAll();
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Users findById(Long id) throws Exception{
        try{
            Optional<Users> searchUser = usersRepository.findById(id);
            if (searchUser.isPresent()){
                return searchUser.get();
            } else {
                throw new Exception("Entidad no encontrada");
            }
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Users save(Users newUser) throws Exception {
        try{
            return usersRepository.save(newUser);
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Users update(Long id, Users newUser) throws Exception {
        try {
            Optional<Users> existingUser = usersRepository.findById(id);
            if (existingUser.isPresent()) {
                Users userToUpdate = existingUser.get();
                userToUpdate.setName(newUser.getName());
                userToUpdate.setEmail(newUser.getEmail());

                return usersRepository.save(userToUpdate);
            } else {
                throw new Exception("Usuario no encontrado");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if (usersRepository.existsById(id)){
                usersRepository.deleteById(id);
                return true;
            }else {
                throw new Exception("Entidad no encontrada");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
