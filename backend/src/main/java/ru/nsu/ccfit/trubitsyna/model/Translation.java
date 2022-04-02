package ru.nsu.ccfit.trubitsyna.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "translations")
public class Translation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private long id;

    @ManyToOne
    @JoinColumn(name = "song_id")
    @Getter
    private Song song;

    @ManyToOne
    @JoinColumn(name = "author_id")
    @Getter
    private User user;

    @ManyToOne 
    @JoinColumn(name = "language_id")
    @Getter
    private Language language;

    @Lob
    @Column(name = "text")
    @Getter @Setter
    private String text;

    @Column(name = "like_count")
    @Getter @Setter
    private long likeCount;


}
