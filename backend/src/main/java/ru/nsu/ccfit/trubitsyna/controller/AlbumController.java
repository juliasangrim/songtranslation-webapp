package ru.nsu.ccfit.trubitsyna.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.nsu.ccfit.trubitsyna.model.Album;
import ru.nsu.ccfit.trubitsyna.repo.AlbumRepository;

@RestController
@RequestMapping("/api")
public class AlbumController {
    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/albums")
    public ResponseEntity<Set<Album>> getAllAlbums() {
        Set<Album> albums = new HashSet<Album>();
        albumRepository.findAll().forEach(albums::add);
        if (albums.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }

    @GetMapping("/albums")
    public ResponseEntity<Album> getAlbumByName(@RequestParam String albumName) {
        Album albums = albumRepository.findByAlbumName(albumName);

        if (albums == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(albums, HttpStatus.OK);

    }

    @GetMapping("/albums/{id}")
    public ResponseEntity<Album> getAlbumById(@PathVariable("id") long id) {
        Album album = albumRepository.findById(id)
        .orElseThrow(IllegalAccessError::new);
        return new ResponseEntity<>(album, HttpStatus.OK);
    }

    @PostMapping("/albums")
    public ResponseEntity<Album> createAlbum(@RequestBody Album album) {
        System.out.println(album);
        Album _album = albumRepository.save(new Album(album.getAlbumName()));
        return new ResponseEntity<Album>(_album, HttpStatus.CREATED);
    
    }

    @DeleteMapping("/albums/{id}")
    public ResponseEntity<HttpStatus> deleteAlbum(@PathVariable("id") long id) {
        albumRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/albums")
    public ResponseEntity<HttpStatus> deleteAllAlbums() {
        albumRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
