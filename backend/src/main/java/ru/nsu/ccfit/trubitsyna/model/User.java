package ru.nsu.ccfit.trubitsyna.model;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private long id;

    @Column(name = "name")
    @Getter @Setter
    private String name;

    @Lob
    @Column(name = "login")
    @Getter @Setter
    private String login;

    @Lob
    @Column(name = "password")
    @Getter @Setter
    private String password;
    
    @Column(name = "like_count")
    @Getter @Setter
    private long likeCount; 
    @OneToMany(mappedBy = "user")
    @Getter
    private Set<Translation> translations;

    @ManyToMany
    @JoinTable(
  		name = "user_info", 
  		joinColumns = @JoinColumn(name = "user_id"), 
  		inverseJoinColumns = @JoinColumn(name = "language_id"))
    @Getter
    private Set<Language> languages;
}
