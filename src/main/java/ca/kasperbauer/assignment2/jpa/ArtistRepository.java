package ca.kasperbauer.assignment2.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
        path = "artists",
        collectionResourceRel = "artists",
        itemResourceRel = "artist"
)
public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
