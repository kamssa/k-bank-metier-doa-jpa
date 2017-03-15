package ci.kossovo.bank.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ci.kossovo.bank.entites.Client;
import ci.kossovo.bank.repositories.ClientRepository;
@Service
public class ClientMetier implements IClientMetier{

@Autowired
 ClientRepository clientRepository;
	@Override
	public Client saveClient(Client c) {
		// TODO Auto-generated method stub
		return clientRepository.save(c);
	}

	@Override
	public List<Client> getAllClients() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
	}

}
