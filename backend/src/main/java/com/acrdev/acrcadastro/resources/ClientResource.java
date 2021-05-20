package com.acrdev.acrcadastro.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acrdev.acrcadastro.entities.Client;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
	
	@GetMapping
	public ResponseEntity<List<Client>> findAll(){
		List<Client> list = new ArrayList<>();
		list.add(new Client(1L, "Maria", "123", 2.0, null, 1 ) );
		list.add(new Client(2L, "Santos", "123", 2.0, null, 1 ) );
		
		return ResponseEntity.ok().body(list);
		
	}

}
