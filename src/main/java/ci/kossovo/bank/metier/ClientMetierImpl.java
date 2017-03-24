package ci.kossovo.bank.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ci.kossovo.bank.dao.ClientRepository;
import ci.kossovo.bank.entites.Client;
@Service
public class ClientMetierImpl implements IClientMetier{

@Autowired
 ClientRepository clientRepository;
	@Override
	public Client saveClient(Client client) {
		//ajout d'un client
		return clientRepository.save(client);
	}

	@Override
	public List<Client> getAllClients() {
		// affiche tous les clients
		return clientRepository.findAll();
	}

}
