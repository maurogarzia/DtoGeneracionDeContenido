package com.DtoGenereacionContenido.Dto.Repositories;

import com.DtoGenereacionContenido.Dto.Entities.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
