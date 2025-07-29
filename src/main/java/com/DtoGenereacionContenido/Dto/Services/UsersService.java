package com.DtoGenereacionContenido.Dto.Services;

import com.DtoGenereacionContenido.Dto.Entities.Posts;
import com.DtoGenereacionContenido.Dto.Entities.Users;
import com.DtoGenereacionContenido.Dto.Repositories.UsersRepository;
import com.DtoGenereacionContenido.Dto.dtos.UserCreateDTO;
import com.DtoGenereacionContenido.Dto.dtos.UserDTO;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<UserDTO> findAll() throws Exception {
        try {
            return usersRepository.findAll()
                    .stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public UserDTO findById(Long id) throws Exception {
        Users user = usersRepository.findById(id)
                .orElseThrow(() -> new Exception("Usuario no encontrado"));
        return convertToDTO(user);
    }

    public UserDTO save(UserCreateDTO dto) throws Exception {
        Users user = new Users();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        Users saved = usersRepository.save(user);
        return convertToDTO(saved);
    }

    public UserDTO update(Long id, UserCreateDTO dto) throws Exception {
        Users user = usersRepository.findById(id)
                .orElseThrow(() -> new Exception("Usuario no encontrado"));

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        Users updated = usersRepository.save(user);
        return convertToDTO(updated);
    }

    public boolean delete(Long id) throws Exception {
        if (usersRepository.existsById(id)) {
            usersRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    private UserDTO convertToDTO(Users user) {
        List<String> postTitles = null;
        if (user.getPosts() != null) {
            postTitles = user.getPosts()
                    .stream()
                    .map(Posts::getTitle)
                    .collect(Collectors.toList());
        }

        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                postTitles
        );
    }
}
