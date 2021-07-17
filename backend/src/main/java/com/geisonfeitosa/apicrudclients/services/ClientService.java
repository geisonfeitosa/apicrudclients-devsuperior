package com.geisonfeitosa.apicrudclients.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.geisonfeitosa.apicrudclients.dto.ClientDTO;
import com.geisonfeitosa.apicrudclients.entities.Client;
import com.geisonfeitosa.apicrudclients.repository.ClientRepository;
import com.geisonfeitosa.apicrudclients.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;

	
	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(PageRequest pageRequest) {
		Page<Client> list = clientRepository.findAll(pageRequest);
		return list.map(i -> new ClientDTO(i));
	}
	
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> opt = clientRepository.findById(id);
		Client entity = opt.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new ClientDTO(entity);
	}
	
}
