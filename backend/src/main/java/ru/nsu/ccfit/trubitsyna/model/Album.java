package ru.nsu.ccfit.trubitsyna.model;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "albums")
public class Album {
    @Id
    @Getter
    private long id;

    @Column(name = "album_name")
    @Getter @Setter
    private String albumName;

    @OneToMany(mappedBy = "album")
    @Getter
    private Set<Song> songs;
    
}
