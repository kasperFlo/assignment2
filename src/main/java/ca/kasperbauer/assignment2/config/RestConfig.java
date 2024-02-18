package ca.kasperbauer.assignment2.config;

import ca.kasperbauer.assignment2.jpa.Artist;
import ca.kasperbauer.assignment2.jpa.Artwork;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Component
public class RestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(Artist.class); // Expose IDs for Artist
        config.exposeIdsFor(Artwork.class); // Expose IDs for Artwork
    }
}
