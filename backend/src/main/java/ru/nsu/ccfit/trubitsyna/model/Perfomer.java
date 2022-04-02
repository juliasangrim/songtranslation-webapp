package ru.nsu.ccfit.trubitsyna.model;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "perfomers")
public class Perfomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private long id;

    @Column(name = "performer_name")
    @Getter @Setter
    private String name;

    @ManyToMany
    @Getter
    private Set<Song> songs;
}
