package com.DtoGenereacionContenido.Dto.Repositories;

import com.DtoGenereacionContenido.Dto.Entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
}
