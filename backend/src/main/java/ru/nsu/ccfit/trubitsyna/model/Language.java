package ru.nsu.ccfit.trubitsyna.model;


import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NoArgsConstructor
@Table(name = "languages")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private long id;

    @Column(name = "name")
    @NotBlank
    @Getter @Setter
    private String languageName;

    public Language(String name) {
        this.languageName = name;
    }

}