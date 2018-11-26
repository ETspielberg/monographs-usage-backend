package unidue.ub.services.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import unidue.ub.media.analysis.EbsData;
import unidue.ub.services.data.repository.EbsDataRepository;

@Controller
public class EbsDataController {

    @Autowired
    EbsDataRepository ebsDataRepository;

    @GetMapping("/ebsData/getForEbsModel")
    ResponseEntity<?> getEbsDataForModel(String ebsModel) {
        return ResponseEntity.ok(ebsDataRepository.getAllByEbsModel(ebsModel));
    }

    @PostMapping("/ebsData/saveList")
    ResponseEntity<?> saveEbsDataList(@RequestBody EbsData[] ebsDatas) {
        int saved = 0;
        int problem = 0;
        for (EbsData ebsData : ebsDatas) {
            try {
                ebsDataRepository.save(ebsData);
                saved++;
            } catch (Exception e) {
                problem++;
            }
        }
        return ResponseEntity.ok("saved " + String.valueOf(saved) + " out of " + String.valueOf(ebsDatas.length) + " and encountered " + String.valueOf(problem) + " problems.");
    }
}
