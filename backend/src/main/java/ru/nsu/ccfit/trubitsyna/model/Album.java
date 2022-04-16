package ru.nsu.ccfit.trubitsyna.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "albums")
public class Album {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "album_name")
    @NotBlank
    @Getter @Setter
    private String albumName;

    public Album() {

    }


    public Album(String name) {
        this.albumName = name;
    }
}
