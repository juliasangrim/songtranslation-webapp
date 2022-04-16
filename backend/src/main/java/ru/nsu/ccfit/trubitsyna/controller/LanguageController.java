package ru.nsu.ccfit.trubitsyna.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.nsu.ccfit.trubitsyna.model.Language;
import ru.nsu.ccfit.trubitsyna.repo.LanguageRepository;

@RestController
@RequestMapping("/api")
public class LanguageController {
    @Autowired
    LanguageRepository languageRepository;

    @GetMapping("/languages")
    public ResponseEntity<Set<Language>> getAllLanguages() {
        Set<Language> languages = new HashSet<Language>();
        languageRepository.findAll().forEach(languages::add);
    
        if (languages.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(languages, HttpStatus.OK);
    }


    @GetMapping("/languages")
    public ResponseEntity<Language> getLanguageByName(@RequestBody String name) {
        Language language = languageRepository.findByShortName(name);
        if (language == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(language, HttpStatus.OK);
    }

    @GetMapping("/languages")
    public ResponseEntity<Language> getLanguageById(@RequestBody long id) {
        Language language = languageRepository.findById(id)
        .orElseThrow(IllegalAccessError::new);
        return new ResponseEntity<>(language, HttpStatus.OK);
    }

    @PostMapping("/languages")
    public ResponseEntity<Language> createLanguage(@RequestBody Language language) {
        Language _language = languageRepository.save(new Language(language.getLanguageName(), language.getShortName()));
        return new ResponseEntity<>(_language, HttpStatus.CREATED);
    
    }

    @DeleteMapping("/languages")
    public ResponseEntity<HttpStatus> deleteAlbum(@RequestBody long id) {
        languageRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/languages")
    public ResponseEntity<HttpStatus> deleteAllAlbums() {
        languageRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
