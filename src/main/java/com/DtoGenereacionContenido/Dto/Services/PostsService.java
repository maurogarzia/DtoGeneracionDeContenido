package com.DtoGenereacionContenido.Dto.Services;

import com.DtoGenereacionContenido.Dto.Entities.Posts;
import com.DtoGenereacionContenido.Dto.Repositories.PostsRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostsService {

    private final PostsRepository postsRepository;

    public PostsService(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    @Transactional
    public List<Posts> findAll() throws Exception {
        try{
            return postsRepository.findAll();
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Posts findById(Long id) throws Exception {
        try{
            Optional<Posts>searchPost = postsRepository.findById(id);
            if (searchPost.isPresent()){
                return searchPost.get();
            } else {
                throw new Exception("Entidad no encontrada");
            }
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Posts save(Posts newPosts) throws Exception {
        try{
            return postsRepository.save(newPosts);
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Posts update(Long id, Posts newPost) throws Exception {
        try {
            Optional<Posts> existingPost = postsRepository.findById(id);
            if (existingPost.isPresent()) {
                Posts postToUpdate = existingPost.get();
                postToUpdate.setTitle(newPost.getTitle());
                postToUpdate.setContent(newPost.getContent());
                postToUpdate.setUser(newPost.getUser());


                return postsRepository.save(postToUpdate);
            } else {
                throw new Exception("Post no encontrado");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public boolean delete(Long id) throws Exception {
        try{
            if (postsRepository.existsById(id)){
                postsRepository.deleteById(id);
                return true;
            } else {
                throw new Exception("Entidad no encontrada");
            }
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }


}
