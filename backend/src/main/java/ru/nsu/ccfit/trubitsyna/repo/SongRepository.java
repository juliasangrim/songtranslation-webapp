package ru.nsu.ccfit.trubitsyna.repo;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.nsu.ccfit.trubitsyna.model.*;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
  Set<Song> findBySongName(String songName);

}