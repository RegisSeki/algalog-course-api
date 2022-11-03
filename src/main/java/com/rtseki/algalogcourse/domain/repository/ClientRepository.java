package com.rtseki.algalogcourse.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rtseki.algalogcourse.domain.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	
	List<Client> findByName(String name);
	List<Client> findByNameContaining(String name);
}
