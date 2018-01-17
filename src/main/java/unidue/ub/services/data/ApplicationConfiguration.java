package unidue.ub.services.data;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import unidue.ub.media.analysis.*;

@Configuration
public class ApplicationConfiguration extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Counter.class, Documentanalysis.class, Eventanalysis.class, JournalRequest.class, Nrequests.class, Shelfanalysis.class);
    }
}
