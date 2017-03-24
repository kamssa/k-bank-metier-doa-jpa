package ci.kossovo.bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import ci.kossovo.bank.entites.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

}
