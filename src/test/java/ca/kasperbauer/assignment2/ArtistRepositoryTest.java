package ca.kasperbauer.assignment2;

import ca.kasperbauer.assignment2.jpa.Artwork;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ca.kasperbauer.assignment2.jpa.ArtistRepository;  // Adjust 'ca.kasperbauer.assignment2.jpa' to match your package
import ca.kasperbauer.assignment2.jpa.Artist; // Assuming your Artist class is in the same package

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class ArtistRepositoryTest {

    @Autowired
    private ArtistRepository artistRepository;
    @BeforeAll
    public static void beforeAll() {
        System.out.println("        ****** Starting Database Tests ******");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("        ****** Database Tests Completed ******");
    }
    @Test
    public void canSaveAndFindArtist() {

        Artist hokusei = new Artist("Katsushika Hokusei", "Japanese", 1760);
        Artwork GreatWave = new Artwork(null, "Great Wave off Kanagawa", 1831, "Painting", hokusei,"GreatWaveoffKanagawa.png");
        Artwork FineWind = new Artwork(null, "Fine Wind, Clear Morning", 1937, "Painting", hokusei, "FineWindClearMorning.png");

        hokusei.addArtwork(FineWind);
        hokusei.addArtwork(GreatWave);
        artistRepository.save(hokusei);

        Optional<Artist> foundArtist = artistRepository.findById(hokusei.getId());

        assertTrue(foundArtist.isPresent());
    }

    @Test
    public void canSaveAndFindArtwork() {
        // Set up
        Artist hokusei = new Artist("Katsushika Hokusei", "Japanese", 1760);
        Artwork greatWave = new Artwork(null, "Great Wave off Kanagawa", 1831, "Painting", hokusei, "GreatWaveoffKanagawa.png");
        Artwork fineWind = new Artwork(null, "Fine Wind, Clear Morning", 1937, "Painting", hokusei, "FineWindClearMorning.png");

        hokusei.addArtwork(fineWind);
        hokusei.addArtwork(greatWave);
        artistRepository.save(hokusei);

        // Fetch saved artist
        Optional<Artist> foundArtist = artistRepository.findById(hokusei.getId());

        assertTrue(foundArtist.isPresent());

        // Ensure the correct number of artworks were saved
        assertEquals(2, foundArtist.get().getArtworks().size());

        // Check for a specific artwork (using Artwork's 'title' here)
        assertTrue(foundArtist.get().getArtworks().stream()
                .anyMatch(artwork -> artwork.getTitle().equals("Great Wave off Kanagawa")));
    }
}
