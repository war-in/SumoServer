package com.sumo.server.apis.ProfilePictureController;

import com.sumo.server.Database.ProfileData.ProfilePicture.ProfilePicture;
import com.sumo.server.Database.ProfileData.ProfilePicture.ProfilePictureService;
import com.sumo.server.Database.ProfileData.ProfilePicture.ResponseFile;
import com.sumo.server.Database.ProfileData.ProfilePicture.ResponseMessage;
import com.sumo.server.Database.userData.PersonalDetails.PersonalDetailsRepository;
import com.sumo.server.Database.userData.PersonalDetails.PersonalDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/profile-pictures")
@RequiredArgsConstructor
public class ProfilePictureController {
    final ProfilePictureService profilePictureService;
    final PersonalDetailsService personalDetailsService;

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam(name = "personal-details-id") long id) {
        String msg = "";

        try {
            profilePictureService.save(file, id);
            ProfilePicture dbFile = profilePictureService.getPictureByPersonalId(id);
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/profile-pictures/")
                    .path(String.valueOf(dbFile.getId()))
                    .toUriString();
            personalDetailsService.updateLinkToProfilePicture(id, fileDownloadUri);

            msg = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.ok().body(new ResponseMessage(msg));
        } catch (IOException e) {
            msg = "Could not upload the file: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(msg));
        }
    }

    @GetMapping()
    public ResponseEntity<List<ResponseFile>> getAllFiles() {
        List<ResponseFile> files = profilePictureService.getAllPictures().map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/profile-pictures/")
                    .path(String.valueOf(dbFile.getId()))
                    .toUriString();
            return new ResponseFile(
                    dbFile.getName(),
                    fileDownloadUri,
                    dbFile.getType(),
                    dbFile.getData().length);
        }).toList();
        return ResponseEntity.ok().body(files);
    }

    @GetMapping("{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable long id) {
        ProfilePicture profilePicture = profilePictureService.getPicture(id);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + profilePicture.getName() + "\"")
                .body(profilePicture.getData());
    }
}
