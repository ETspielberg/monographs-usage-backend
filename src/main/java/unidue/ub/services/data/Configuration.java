package unidue.ub.services.data;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import unidue.ub.media.analysis.*;

public class Configuration extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.getCorsRegistry()
                .addMapping("/**")
                .allowedOrigins("http://localhost:3000").allowedMethods("GET", "PUT", "DELETE", "POST");
        config.exposeIdsFor(Counter.class, Documentanalysis.class, Eventanalysis.class, JournalRequest.class, Nrequests.class, Shelfanalysis.class);
    }
}
