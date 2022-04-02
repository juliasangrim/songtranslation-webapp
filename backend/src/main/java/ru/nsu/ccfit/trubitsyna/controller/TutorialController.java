package ru.nsu.ccfit.trubitsyna.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.ccfit.trubitsyna.model.*;
import ru.nsu.ccfit.trubitsyna.repo.*;

//@CrossOrigin(origins = "http://localhost:8081")
// @RestController
// @RequestMapping("/api")
// public class TutorialController {

// 	@Autowired
// 	TutorialRepository tutorialRepository;

// 	@GetMapping("/tutorials")
// 	public ResponseEntity<List<Song>> getAllTutorials(@RequestParam(required = false) String title) {
// 		try {
// 			List<Song> tutorials = new ArrayList<Song>();
// 			if (title == null)
// 				tutorialRepository.findAll().forEach(tutorials::add);
// 			else
// 				tutorialRepository.findByTitleContaining(title).forEach(tutorials::add);
// 			if (tutorials.isEmpty()) {
// 				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
// 			}
// 			return new ResponseEntity<>(tutorials, HttpStatus.OK);
// 		} catch (Exception e) {
// 			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
// 		}
// 	}

// 	@GetMapping("/tutorials/{id}")
// 	public ResponseEntity<Song> getTutorialById(@PathVariable("id") long id) {
// 		Optional<Song> tutorialData = tutorialRepository.findById(id);
// 		if (tutorialData.isPresent()) {
// 			return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
// 		} else {
// 			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
// 		}
// 	}

// 	@PostMapping("/tutorials")
// 	public ResponseEntity<Song> createTutorial(@RequestBody Song tutorial) {
// 		try {
// 			Song _tutorial = tutorialRepository
// 					.save(new Song(tutorial.getTitle(), tutorial.getDescription(), false));
// 			return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
// 		} catch (Exception e) {
// 			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
// 		}
// 	}

// 	@PutMapping("/tutorials/{id}")
// 	public ResponseEntity<Song> updateTutorial(@PathVariable("id") long id, @RequestBody Song tutorial) {
// 		Optional<Song> tutorialData = tutorialRepository.findById(id);
// 		if (tutorialData.isPresent()) {
// 			Song _tutorial = tutorialData.get();
// 			_tutorial.setTitle(tutorial.getTitle());
// 			_tutorial.setDescription(tutorial.getDescription());
// 			_tutorial.setPublished(tutorial.isPublished());
// 			return new ResponseEntity<>(tutorialRepository.save(_tutorial), HttpStatus.OK);
// 		} else {
// 			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
// 		}
// 	}

// 	@DeleteMapping("/tutorials/{id}")
// 	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
// 		try {
// 			tutorialRepository.deleteById(id);
// 			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
// 		} catch (Exception e) {
// 			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
// 		}
// 	}

// 	@DeleteMapping("/tutorials")
// 	public ResponseEntity<HttpStatus> deleteAllTutorials() {
// 		try {
// 			tutorialRepository.deleteAll();
// 			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
// 		} catch (Exception e) {
// 			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
// 		}
// 	}

// 	@GetMapping("/tutorials/published")
// 	public ResponseEntity<List<Song>> findByPublished() {
// 		try {
// 			List<Song> tutorials = tutorialRepository.findByPublished(true);
// 			if (tutorials.isEmpty()) {
// 				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
// 			}
// 			return new ResponseEntity<>(tutorials, HttpStatus.OK);
// 		} catch (Exception e) {
// 			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
// 		}
// 	}
//}
