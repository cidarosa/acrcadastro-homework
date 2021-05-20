package com.acrdev.acrcadastro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acrdev.acrcadastro.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
