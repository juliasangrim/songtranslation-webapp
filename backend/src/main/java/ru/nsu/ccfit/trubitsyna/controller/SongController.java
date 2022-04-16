package ru.nsu.ccfit.trubitsyna.controller;


import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.ccfit.trubitsyna.model.*;
import ru.nsu.ccfit.trubitsyna.repo.*;

// @CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class SongController {

	@Autowired
	SongRepository songRepository;
	@Autowired
	LanguageRepository languageRepository;
	@Autowired
	AlbumRepository albumRepository;

	@PostMapping("/songs")
	public ResponseEntity<Song> createSong(@RequestParam String album_name, 
	@RequestParam String language_name,
		@RequestBody Song songRequest) {
		System.out.println(album_name);
		System.out.println(language_name);
		Album album = albumRepository.findByAlbumName(album_name);
		if (album == null) {
			albumRepository.save(new Album(album_name));
		} else {
			songRequest.setAlbum(album);
		}
		Language language = languageRepository.findByShortName(language_name);
		if (language == null) {
			languageRepository.sve(new Language(name, shortName))
		}
		// songRequest.setAlbum(album);

		// Language language = languageRepository.findById(language_id).orElseThrow(IllegalAccessError::new);
		// songRequest.setLanguage(language);
		// songRepository.save(songRequest);
		return new ResponseEntity<>(songRequest, HttpStatus.CREATED);
	}

// 	@PutMapping("/comments/{id}")
// 	public ResponseEntity<Comment> updateComment(@PathVariable("id") long id, @RequestBody Comment commentRequest) {
// 	  Comment comment = commentRepository.findById(id)
// 		  .orElseThrow(() -> new ResourceNotFoundException("CommentId " + id + "not found"));
// 	  comment.setContent(commentRequest.getContent());
// 	  return new ResponseEntity<>(commentRepository.save(comment), HttpStatus.OK);
// 	}
// 	@DeleteMapping("/comments/{id}")
// 	public ResponseEntity<HttpStatus> deleteComment(@PathVariable("id") long id) {
// 	  commentRepository.deleteById(id);
// 	  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
// 	}
	
// 	@DeleteMapping("/tutorials/{tutorialId}/comments")
// 	public ResponseEntity<List<Comment>> deleteAllCommentsOfTutorial(@PathVariable(value = "tutorialId") Long tutorialId) {
// 	  if (!tutorialRepository.existsById(tutorialId)) {
// 		throw new ResourceNotFoundException("Not found Tutorial with id = " + tutorialId);
// 	  }
// 	  commentRepository.deleteByTutorialId(tutorialId);
// 	  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
// 	}
//   }
}
