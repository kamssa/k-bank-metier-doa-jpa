package ci.kossovo.bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ci.kossovo.bank.entites.Compte;

public interface CompteRepository extends JpaRepository<Compte, String>{

}
