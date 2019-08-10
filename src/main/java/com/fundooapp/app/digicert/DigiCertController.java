package com.fundooapp.app.digicert;

import com.fundooapp.app.entity.Entity;
import com.fundooapp.app.entity.UploadDocDetails;
import com.fundooapp.app.event.Event;
import com.fundooapp.app.event.UploadDocBaseEvent;
import com.fundooapp.app.repository.EventHandler;
import com.fundooapp.app.repository.UploadDocEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.websocket.server.PathParam;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/v1")
public class DigiCertController {

    @Autowired
    private UploadDocEventRepository uploadDocEventRepository;

    @Autowired
    @Qualifier(value = "userEventHandler")
    private EventHandler<Event<Entity>> eventEventHandler;

    //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "/Users/kranthikillo/Documents/fundoRings/";

    @PostMapping(value = "/upload")
    public ResponseEntity<UploadDocDetails> upload(@RequestParam("file") MultipartFile file,
                                                   @PathParam("documentNm") String documentNm,
                                                   @PathParam("issuerId") String issuerId){

        if (file.isEmpty()) {
            return null;
        }
        String filePathLoc = null;
        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            filePathLoc = path.toString();
            Files.write(path, bytes);

            System.out.println("You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         * user
         */

        UploadDocDetails docDetails = constructUploadDoc(documentNm, issuerId, filePathLoc);

        UploadDocBaseEvent baseEvent = null;

        //eventEventHandler.onEvent(baseEvent);

        return ResponseEntity.ok().body(docDetails);
    }

    private UploadDocDetails constructUploadDoc(String documentNm, String userId, String filePathLoc) {

        return null;
    }

    @GetMapping("/ulIndex")
    public String index() {
        return "upload";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }
}
