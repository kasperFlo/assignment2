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

        Artist picasso = new Artist("Pablo Picasso", "Spanish", 1881);

        // Artwork creation using the new constructor:
        Artwork guernica = new Artwork(null, "Guernica", 1937, "Painting", picasso);
        Artwork lesDemoiselles = new Artwork(null, "Les Demoiselles d'Avignon", 1907, "Painting", picasso);


        Artist hokusei = new Artist("Katsushika Hokusei", "Japanese", 1760);

        Artwork GreatWave = new Artwork(null, "Great Wave off Kanagawa", 1831, "Painting", hokusei);
        Artwork FineWind = new Artwork(null, "Fine Wind, Clear Morning", 1937, "Painting", hokusei);

        picasso.addArtwork(guernica);
        picasso.addArtwork(lesDemoiselles);
        artistRepository.save(picasso);

        hokusei.addArtwork(FineWind);
        hokusei.addArtwork(GreatWave);
        artistRepository.save(hokusei);

        artistRepository.flush();
    }
}
