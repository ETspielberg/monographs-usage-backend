package unidue.ub.services.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import unidue.ub.services.data.repository.EventanalysisRepository;

import java.util.Map;

@Controller
public class EventanalysisController {

    @Autowired
    EventanalysisRepository eventanalysisRepository;

    @PostMapping("eventanalysis/setAnalysisStatus")
    public HttpStatus setAnalysisToOld(@RequestBody Map<String, String> json) {
        eventanalysisRepository.setEventanalysisStatusForStockcontrolIds(json.get("identifier"),json.get("status"));
        return HttpStatus.FOUND;
    }
}
