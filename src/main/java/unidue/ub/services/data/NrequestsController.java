package unidue.ub.services.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import unidue.ub.media.analysis.Nrequests;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class NrequestsController {

    @Autowired
    private NrequestsRepository nrequestsRepository;

    private Logger log = LoggerFactory.getLogger(NrequestsController.class);

    @GetMapping("/nrequests/getForTimeperiod")
    public ResponseEntity<?> getNrequestsForLastDays(@Param("startNotation") String startNotation, @Param("endNotation") String endNotation, @Param("ratio") Double ratio, @Param("duration") Integer duration, @Param(value="thresholdNrequests") Integer thresholdNrequests, @Param(value="timeperiod") Integer timeperiod) {

        log.info(String.valueOf(thresholdNrequests));
        LocalDateTime startDate = LocalDateTime.now().minusDays(timeperiod);
        ZonedDateTime zonedStartDate = startDate.atZone(ZoneId.systemDefault());
        Date date = Date.from(zonedStartDate.toInstant());
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.MILLISECOND, 0);
        log.info(new Timestamp(cal.getTimeInMillis()).toString());

        List<Nrequests> nrequests = nrequestsRepository.getFilteredNrequestsForNotationgroup(startNotation,endNotation,ratio,duration,thresholdNrequests, new Timestamp(cal.getTimeInMillis()));
        if (nrequests == null)
            nrequests = new ArrayList<>();
        return ResponseEntity.ok(nrequests);

    }

}
