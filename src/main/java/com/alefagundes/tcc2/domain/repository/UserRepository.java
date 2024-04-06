package com.alefagundes.tcc2.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alefagundes.tcc2.domain.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findByEmail(String email);

    Optional<User> findByNome(String nome);

    Boolean existsByEmail(String email);
    
}
