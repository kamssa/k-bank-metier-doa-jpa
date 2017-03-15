package ci.kossovo.bank.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import ci.kossovo.bank.entites.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
