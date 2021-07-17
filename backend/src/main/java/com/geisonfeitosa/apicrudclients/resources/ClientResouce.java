package com.geisonfeitosa.apicrudclients.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.geisonfeitosa.apicrudclients.dto.ClientDTO;
import com.geisonfeitosa.apicrudclients.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResouce {
	
	@Autowired
	private ClientService clientService;
	
	
	@GetMapping
	public ResponseEntity<Page<ClientDTO>> findAllPaged(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy
			) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		Page<ClientDTO> list = clientService.findAllPaged(pageRequest);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ClientDTO> findById(@PathVariable Long id) {
		ClientDTO catDTO = clientService.findById(id);	
		return ResponseEntity.ok().body(catDTO);
	}
	
}
