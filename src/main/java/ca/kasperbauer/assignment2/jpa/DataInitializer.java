package ca.kasperbauer.assignment2.jpa;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class DataInitializer {
    private final ArtistRepository artistRepository;

    public DataInitializer(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @PostConstruct
    public void init(){

        Artist picasso = new Artist("Pablo", "Picasso", "Spanish", 1881);

        // Artwork creation using the new constructor:
        Artwork guernica = new Artwork(null, "Guernica", 1937, "Painting", picasso);
        Artwork lesDemoiselles = new Artwork(null, "Les Demoiselles d'Avignon", 1907, "Painting", picasso);

        picasso.addArtwork(guernica);
        picasso.addArtwork(lesDemoiselles);
        artistRepository.save(picasso);

        // ... (Similar pattern for other artists and artworks)

        artistRepository.flush();
    }
}
