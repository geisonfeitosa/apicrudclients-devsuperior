package com.geisonfeitosa.apicrudclients.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.geisonfeitosa.apicrudclients.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
