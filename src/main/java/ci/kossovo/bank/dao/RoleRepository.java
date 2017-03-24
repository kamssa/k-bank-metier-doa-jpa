package ci.kossovo.bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ci.kossovo.bank.entites.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	// recherche d'un rôle via son nom
	Role findRoleByName(String name);

}
