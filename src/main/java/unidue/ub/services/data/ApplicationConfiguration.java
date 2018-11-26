package unidue.ub.services.data;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import unidue.ub.media.analysis.*;
import unidue.ub.services.data.model.Contactperson;
import unidue.ub.services.data.model.Service;
import unidue.ub.services.data.model.Servicecategory;

@Configuration
public class ApplicationConfiguration extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Counter.class, Documentanalysis.class, Eventanalysis.class, JournalRequest.class, Nrequests.class, Shelfanalysis.class, EbsData.class, Comment.class, DeletionList.class, CounterLog.class, Service.class, Servicecategory.class, Contactperson.class);
    }
}
