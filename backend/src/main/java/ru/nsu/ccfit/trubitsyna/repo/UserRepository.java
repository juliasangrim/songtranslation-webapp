package ru.nsu.ccfit.trubitsyna.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.nsu.ccfit.trubitsyna.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>  {
    
}
