package ru.nsu.ccfit.trubitsyna.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.nsu.ccfit.trubitsyna.model.Performer;

@Repository
public interface PerformerRepository extends JpaRepository<Performer, Long> {
    Performer findByPerformerName(String performerName);
}
