package com.rtseki.algalogcourse.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rtseki.algalogcourse.domain.exception.BusinessException;
import com.rtseki.algalogcourse.domain.model.Client;
import com.rtseki.algalogcourse.domain.repository.ClientRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CatalogClientService {
	
	private ClientRepository clientRepository;
	
	@Transactional
	public Client save(Client client) {
		boolean isUsedEmail = clientRepository.findByEmail(client.getEmail())
				.stream().anyMatch(existClient -> !existClient.equals(client));
		
		if (isUsedEmail) {
			throw new BusinessException("This email is already in use!");
		}
		
		return clientRepository.save(client);
	}
	
	@Transactional
	public void delete(Long clientId) {
		clientRepository.deleteById(clientId);
	}
}
