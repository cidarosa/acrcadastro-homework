package com.acrdev.acrcadastro.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acrdev.acrcadastro.dto.ClienteDTO;
import com.acrdev.acrcadastro.entities.Client;
import com.acrdev.acrcadastro.repositories.ClientRepository;
import com.acrdev.acrcadastro.services.exceptions.DatabaseException;
import com.acrdev.acrcadastro.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;

	@Transactional(readOnly = true)
	public List<ClienteDTO> findAll() {
		List<Client> list = repository.findAll();
		// converter list para listDTO
		// List<ClienteDTO> listDto = list.stream().map(x -> new
		// ClienteDTO(x)).collect(Collectors.toList());

		return list.stream().map(x -> new ClienteDTO(x)).collect(Collectors.toList());

	}

	@Transactional(readOnly = true)
	public ClienteDTO findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		Client entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));

		return new ClienteDTO(entity);
	}

	@Transactional
	public ClienteDTO insert(ClienteDTO dto) {
		// converter dto para entidade
		Client entity = new Client();
		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setIncome(dto.getIncome());
		entity.setBirthDate(dto.getBirthDate());
		entity.setChildren(dto.getChildren());

		entity = repository.save(entity);

		return new ClienteDTO(entity);

	}

	@Transactional
	public ClienteDTO update(Long id, ClienteDTO dto) {
		// instanciar obj Client - não acessa DB

		try {
			Client entity = repository.getOne(id);
			entity.setName(dto.getName());
			entity.setCpf(dto.getCpf());
			entity.setIncome(dto.getIncome());
			entity.setBirthDate(dto.getBirthDate());
			entity.setChildren(dto.getChildren());

			entity = repository.save(entity);

			return new ClienteDTO(entity);
		} catch (EntityNotFoundException e) {

			throw new ResourceNotFoundException("Id not found: " + id);
		}
	}

	public void delete(Long id) {
		
		try {
			repository.deleteById(id);
			
		} catch (EmptyResultDataAccessException e) {
			
			throw new ResourceNotFoundException("Id not found: " + id);
			
		} catch(DataIntegrityViolationException e) {
			
			throw new DatabaseException("Integrity violation");
		}
	}

}
