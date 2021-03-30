package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Client;

public interface IClientService {
	
	public Client addClient(Client client);
	public List<Client> listAll();
	public Client get(Long idClient);
	public String delete(Long idClient);
	public Client updateClient(Client client);
	Client retrieveClient(String c);
	public void update(Long idClient, Client client);
}
