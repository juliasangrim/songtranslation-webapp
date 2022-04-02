package ru.nsu.ccfit.trubitsyna.model;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "songs")
public class Song {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	private long id;

	@ManyToOne
	@JoinColumn(name = "album_id", nullable = false)
	@Getter
	private Album album;

	@Column(name = "name")
	@Getter @Setter
	private String name;

	@ManyToOne
	@JoinColumn(name = "language_id")
	@Getter @Setter
	private Language language;

	@ManyToMany
	@JoinTable(
  		name = "songs_info", 
  		joinColumns = @JoinColumn(name = "song_id"), 
  		inverseJoinColumns = @JoinColumn(name = "perfomer_id"))
	@Getter
	private Set<Perfomer> perfomers;

	@OneToMany(mappedBy = "song")
    @Getter
    private Set<Translation> translation;

	// public Song(long albumId,  description, boolean published) {
	// 	this.title = title;
	// 	this.description = description;
	// 	this.published = published;
	// }

	// @Override
	// public String toString() {
	// 	return "Tutorial [id=" + id + ", title=" + title + ", desc=" + description + ", published=" + published + "]";
	// }



}


