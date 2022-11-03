package com.rtseki.algalogcourse.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rtseki.algalogcourse.domain.model.Client;

@RestController
public class ClientController {
	
	@GetMapping("/clients")
	public List<Client> listar() {
		Client client1 = new Client(1l, "João1", "joao@email.com", "123456789");
		Client client2 = new Client(2l, "Maria", "maria@email.com", "123456781");
		
		return Arrays.asList(client1, client2);
	}
}
