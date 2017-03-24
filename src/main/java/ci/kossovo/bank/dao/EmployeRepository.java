package ci.kossovo.bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ci.kossovo.bank.entites.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Long> {

}
