package ru.nsu.ccfit.trubitsyna.model;


import java.util.List;
import java.util.Set;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "languages")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    @Getter @Setter
    private String name;

    @OneToMany(mappedBy = "language")
    @Getter
    private Set<Song> songs;

    @OneToMany(mappedBy = "language")
    @Getter
    private Set<Translation> translations;

    @ManyToMany
    @Getter
    private Set<User> users;

}