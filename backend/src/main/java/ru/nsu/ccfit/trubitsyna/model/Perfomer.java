package ru.nsu.ccfit.trubitsyna.model;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

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
    @NotBlank
    @Getter @Setter
    private String perfomerName;

    // @ManyToMany(mappedBy = "perfomers")
    // @Getter
    // private Set<Song> songs;

    public Perfomer(String name) {
        this.perfomerName = name;
    }
}
