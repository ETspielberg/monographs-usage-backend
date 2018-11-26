package unidue.ub.services.data.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import unidue.ub.services.data.model.Service;

public class ServiceFilter {

    private String audienceLevel;

    private String target;

    private Logger log = LoggerFactory.getLogger(ServiceFilter.class);

    public ServiceFilter(String audienceLevel, String target) {
        this.audienceLevel = audienceLevel == null ? "" : audienceLevel.trim();
        this.target = target == null ? "" : target.trim();
        log.info("set up filter with target = " + this.target + " and level = " + this.audienceLevel);
    }

    public boolean matches(Service service) {
        return (audienceLevelMatches(service.getAudienceLevel()) && targetMatches(service.getTargetedAudience()));
    }

    private boolean audienceLevelMatches(String[] testAudienceLevel) {
        if (this.audienceLevel.isEmpty())
            return true;
        if (testAudienceLevel == null)
            return false;
        for (String test : testAudienceLevel) {
            log.info("testing " + test);
            if (test.isEmpty())
                return true;
            if (test.trim().equals(this.audienceLevel))
                return true;
        }
        return false;
    }

    private boolean targetMatches(String[] testTarget) {
        if (this.target.isEmpty())
            return true;
        if (testTarget == null)
            return false;
        for (String test : testTarget) {
            if (test.isEmpty())
                return true;
            if (this.target.equals(test.trim()))
                return true;
        }
        return false;
    }
}
