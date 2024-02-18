package ca.kasperbauer.assignment2.jpa;

import com.fasterxml.jackson.annotation.JsonGetter;
import jakarta.persistence.*;

@Entity
public class Artwork {  //  Opening brace for the class

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private int creationYear;
    private String type;

    @ManyToOne
    @JoinColumn(name = "id") // Column for foreign key
    private Artist artist;

    public Artwork(Long id, String title, int creationYear, String type, Artist artist) {
        this.id = id;
        this.title = title;
        this.creationYear = creationYear;
        this.type = type;
        this.artist = artist;
    }

    public Artwork() {

    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public int getCreationYear() { return creationYear; }
    public void setCreationYear(int creationYear) { this.creationYear = creationYear; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public Artist getArtist() { return artist; }
    public void setArtist(Artist artist) { this.artist = artist; }

}
