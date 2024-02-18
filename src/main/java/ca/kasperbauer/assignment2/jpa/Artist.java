package ca.kasperbauer.assignment2.jpa; // Keep your existing package

import com.fasterxml.jackson.annotation.JsonIgnore; // For customization later
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "artist") // Renamed table to 'artist'
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // Combines first and last name
    private String nationality;

    private Integer birthYear;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.PERSIST)
    @JsonIgnore  // Prevents infinite recursion when serializing with Jackson
    private List<Artwork> artworks = new ArrayList<>();

    public Artist() {
    }

    public Artist(String name, String nationality, Integer birthYear, Integer deathYear) {
        this.name = name;
        this.nationality = nationality;
        this.birthYear = birthYear;
    }


    // Getters and Setters ...
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }
    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public List<Artwork> getArtworks() {
        return artworks;
    }

    public void setArtworks(List<Artwork> artworks) {
        this.artworks = artworks;
    }

    public void addArtwork(Artwork artwork) {
        artwork.setArtist(this); // Updated for 'Artwork' entity
        artworks.add(artwork);
    }
}
