package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.service.IClientService;

@RestController
public class ClientController {
	
	@Autowired
	IClientService cs ;
	
	@GetMapping("/clients")
	public ResponseEntity<List<Client>> getAllClients() {
		List<Client> clients = cs.listAll() ;
		return new ResponseEntity<>(clients , HttpStatus.OK);
	}
	
	@PostMapping("/client/add")
	public Client saveClient(@RequestBody Client client){
		return cs.addClient(client) ;
	}
	
	@DeleteMapping("/client/delete/{idClient}")
	public String deleteClient(@PathVariable Long idClient){
		return cs.delete(idClient);
	}
	
	public Client updateClient(@RequestBody Client client){
		return cs.updateClient(client) ;
	}
	 
}
