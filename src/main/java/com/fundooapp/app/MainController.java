package com.fundooapp.app;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class MainController {

    @GetMapping(value = "/landing")
    public ResponseEntity<AccessDetails> landingPage(){
        AccessDetails accessDetails = new AccessDetails();
        accessDetails.setCandidateName("");
        accessDetails.setCompanyName("");
        accessDetails.setDate("");
        return ResponseEntity.ok(accessDetails);
    }
}
