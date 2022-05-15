package ru.nsu.ccfit.trubitsyna.repo;

import java.util.Optional;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.nsu.ccfit.trubitsyna.model.ERole;
import ru.nsu.ccfit.trubitsyna.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByRoleName(ERole name);
}