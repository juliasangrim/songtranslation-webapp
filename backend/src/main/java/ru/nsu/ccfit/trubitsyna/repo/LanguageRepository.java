package ru.nsu.ccfit.trubitsyna.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.nsu.ccfit.trubitsyna.model.Language;

public interface LanguageRepository extends JpaRepository<Language, Long> {
    Language findByShortName(String shortName);       
}
