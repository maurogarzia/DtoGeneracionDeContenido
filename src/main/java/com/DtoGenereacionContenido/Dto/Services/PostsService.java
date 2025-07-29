package com.DtoGenereacionContenido.Dto.Services;

import com.DtoGenereacionContenido.Dto.Entities.Posts;
import com.DtoGenereacionContenido.Dto.Entities.Users;
import com.DtoGenereacionContenido.Dto.Repositories.PostsRepository;
import com.DtoGenereacionContenido.Dto.Repositories.UsersRepository;
import com.DtoGenereacionContenido.Dto.dtos.PostCreateDTO;
import com.DtoGenereacionContenido.Dto.dtos.PostDTO;

import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;

@Service
public class PostsService {

    private final PostsRepository postsRepository;
    private final UsersRepository usersRepository;

    public PostsService(PostsRepository postsRepository, UsersRepository usersRepository) {
        this.postsRepository = postsRepository;
        this.usersRepository = usersRepository;
    }

    public List<PostDTO> findAll() throws Exception {
        try {
            return postsRepository.findAll()
                    .stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public PostDTO findById(Long id) throws Exception {
        Posts post = postsRepository.findById(id)
                .orElseThrow(() -> new Exception("Post no encontrado"));
        return convertToDTO(post);
    }

    public PostDTO save(PostCreateDTO dto) throws Exception {
        Users user = usersRepository.findById(dto.getUserId())
                .orElseThrow(() -> new Exception("Usuario no encontrado"));

        Posts post = new Posts();
        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());
        post.setUser(user);

        Posts saved = postsRepository.save(post);
        return convertToDTO(saved);
    }

    public PostDTO update(Long id, PostCreateDTO dto) throws Exception {
        Posts post = postsRepository.findById(id)
                .orElseThrow(() -> new Exception("Post no encontrado"));

        Users user = usersRepository.findById(dto.getUserId())
                .orElseThrow(() -> new Exception("Usuario no encontrado"));

        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());
        post.setUser(user);

        Posts updated = postsRepository.save(post);
        return convertToDTO(updated);
    }

    public boolean delete(Long id) throws Exception {
        if (postsRepository.existsById(id)) {
            postsRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    private PostDTO convertToDTO(Posts post) {
        return new PostDTO(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getUser().getName()
        );
    }

}
