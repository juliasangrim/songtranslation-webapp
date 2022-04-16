package ru.nsu.ccfit.trubitsyna.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.nsu.ccfit.trubitsyna.model.Perfomer;

@Repository
public interface PerfomerRepository extends JpaRepository<Perfomer, Long> {
}
