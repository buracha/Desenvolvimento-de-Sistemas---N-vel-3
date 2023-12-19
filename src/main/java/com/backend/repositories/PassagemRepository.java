package com.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.models.Passagem;

public interface PassagemRepository extends JpaRepository<Passagem, Integer> {

}
