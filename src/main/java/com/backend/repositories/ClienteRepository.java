package com.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
