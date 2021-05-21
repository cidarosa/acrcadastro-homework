package com.acrdev.acrcadastro.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acrdev.acrcadastro.dto.ClienteDTO;
import com.acrdev.acrcadastro.entities.Client;
import com.acrdev.acrcadastro.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;

	@Transactional(readOnly = true)
	public List<ClienteDTO> findAll() {
		List<Client> list = repository.findAll();
		// converter list para listDTO
		//List<ClienteDTO> listDto = list.stream().map(x -> new ClienteDTO(x)).collect(Collectors.toList());

		return list.stream().map(x -> new ClienteDTO(x)).collect(Collectors.toList());

	}

	@Transactional(readOnly = true)
	public ClienteDTO findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		Client entity = obj.get();
		
		return new ClienteDTO(entity);
	}

}
