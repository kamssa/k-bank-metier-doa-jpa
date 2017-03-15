package ci.kossovo.bank.metier;

import java.util.List;

import ci.kossovo.bank.entites.Client;

public interface IClientMetier {
public Client saveClient(Client c);
public List<Client> getAllClients();
}
