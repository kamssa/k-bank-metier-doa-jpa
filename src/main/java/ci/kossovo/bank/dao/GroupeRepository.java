package ci.kossovo.bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ci.kossovo.bank.entites.Groupe;

public interface GroupeRepository extends JpaRepository<Groupe, Long> {

}
