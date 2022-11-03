package com.rtseki.algalogcourse.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rtseki.algalogcourse.domain.model.Client;
import com.rtseki.algalogcourse.domain.repository.ClientRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/clients")
public class ClientController {

	@Autowired
	private ClientRepository clientRepository;
	
	@GetMapping
	public List<Client> listAll() {
		return clientRepository.findAll();
	}
	
	@GetMapping("/{clientId}")
	public ResponseEntity<Client> findById(@PathVariable Long clientId) {
		return clientRepository.findById(clientId)
			.map(ResponseEntity::ok)
			.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Client create(@RequestBody Client client) {
		return clientRepository.save(client);
	}
	
	@PutMapping("/{clientId}")
	public ResponseEntity<Client> update(@PathVariable Long clientId, @RequestBody Client client) {
		if (!clientRepository.existsById(clientId)) {
			return ResponseEntity.notFound().build();
		}
		
		client.setId(clientId);
		client = clientRepository.save(client);
		
		return ResponseEntity.ok(client);
	}
	
	@DeleteMapping("/{clientId}")
	public ResponseEntity<Client> delete(@PathVariable Long clientId) {
		if (!clientRepository.existsById(clientId)) {
			return ResponseEntity.notFound().build();
		}
		
		clientRepository.deleteById(clientId);
		return ResponseEntity.noContent().build();
	}
}
