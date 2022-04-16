package ru.nsu.ccfit.trubitsyna.model;

import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Table(name = "songs")
public class Song {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Getter
	private long id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@NotNull
	@JoinColumn(name = "album_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@Getter @Setter
	private Album album;

	@Column(name = "name")
	@NotBlank
	@Getter @Setter
	private String songName;

	@Column(name = "text", columnDefinition = "TEXT")
	@NotBlank
	@Getter @Setter
	private String text;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@NotNull
	@JoinColumn(name = "language_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@Getter @Setter
	private Language language;

	// @ManyToMany(cascade = {
    //     CascadeType.PERSIST,
    //     CascadeType.MERGE
    // })
	// @JoinTable(
  	// 	name = "songs_info", 
  	// 	joinColumns = @JoinColumn(name = "song_id"), 
  	// 	inverseJoinColumns = @JoinColumn(name = "perfomer_id"))
	// @Getter
	// private Set<Perfomer> perfomers;


	@OneToMany(mappedBy = "song")
    @Getter
    private Set<Translation> translation;

	public Song(Album album, String name, String text, Language language) {
		this.album = album;
		this.songName = name;
		this.text = text;
		this.language = language;
	}

	// @Override
	// public String toString() {
	// 	return "Tutorial [id=" + id + ", title=" + title + ", desc=" + description + ", published=" + published + "]";
	// }



}


