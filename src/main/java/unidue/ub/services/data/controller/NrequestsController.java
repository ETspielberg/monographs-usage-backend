package unidue.ub.services.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import unidue.ub.media.analysis.Nrequests;
import unidue.ub.services.data.repository.NrequestsRepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

@Controller
public class NrequestsController {

    @Autowired
    private NrequestsRepository nrequestsRepository;

    @GetMapping("/nrequests/getForTimeperiod")
    public ResponseEntity<?> getForTimeperiod(@Param("startNotation") String startNotation, @Param("endNotation") String endNotation, @Param(value="timeperiod") Integer timeperiod) {

        LocalDateTime startDate = LocalDateTime.now().minusDays(timeperiod);
        ZonedDateTime zonedStartDate = startDate.atZone(ZoneId.systemDefault());
        Date date = Date.from(zonedStartDate.toInstant());
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.MILLISECOND, 0);

        List<Nrequests> nrequests = nrequestsRepository.getNrequestsForNotationgroupSinceDate(startNotation,endNotation, new Timestamp(cal.getTimeInMillis()));
        Map<String,Nrequests> maxNrequests = new HashMap<>();
        List<Nrequests> returnList = new ArrayList<>();
        if (nrequests != null) {
            for (Nrequests nrequest : nrequests) {
                if (maxNrequests.containsKey(nrequest.getTitleId())) {
                    Nrequests nrequestsInd = maxNrequests.get(nrequest.getTitleId());
                    nrequest.NRequests = Math.max(nrequestsInd.NRequests, nrequest.NRequests);
                    nrequest.totalDuration = Math.max(nrequestsInd.totalDuration, nrequest.totalDuration);
                    nrequest.setRatio(Math.max(nrequestsInd.getRatio(), nrequest.getRatio()));
                    maxNrequests.put(nrequest.getTitleId(), nrequest);
                } else {
                    maxNrequests.put(nrequest.getTitleId(), nrequest);
                }
            }
            returnList = new ArrayList(maxNrequests.values());
        }
        return ResponseEntity.ok(returnList);

    }

}
