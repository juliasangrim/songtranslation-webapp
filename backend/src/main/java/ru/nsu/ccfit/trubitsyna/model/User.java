package ru.nsu.ccfit.trubitsyna.model;

import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
    @NotBlank
    @Getter @Setter
    private String name;

    @Column(name = "login")
    @NotBlank
    @Getter @Setter
    private String login;

    @Column(name = "password")
    @NotBlank
    @Getter @Setter
    private String password;
    
    @Column(name = "like_count")
    @Getter @Setter
    @NotNull
    private long likeCount; 
    @OneToMany(mappedBy = "user")
    @Getter
    private Set<Translation> translations;

    @ManyToMany(cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE
    })
    @JoinTable(
  		name = "user_info", 
  		joinColumns = @JoinColumn(name = "user_id"), 
  		inverseJoinColumns = @JoinColumn(name = "language_id"))
    @Getter
    private Set<Language> languages;

    
}
