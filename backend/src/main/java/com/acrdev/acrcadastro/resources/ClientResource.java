package com.acrdev.acrcadastro.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acrdev.acrcadastro.entities.Client;
import com.acrdev.acrcadastro.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

	@Autowired
	private ClientService servive;

	@GetMapping
	public ResponseEntity<List<Client>> findAll() {
		List<Client> list = servive.findAll();
		return ResponseEntity.ok().body(list);
	}

}
