package ru.nsu.ccfit.trubitsyna.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.nsu.ccfit.trubitsyna.model.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
    Set<Album> findByAlbumName(String albumName);
}