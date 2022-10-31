package com.sumo.server.Database.ProfileData.ProfilePicture;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

public interface ProfilePictureService {
    ProfilePicture save(MultipartFile profilePicture, long personalDetailsId) throws IOException;

    ProfilePicture getPicture(String id);

    ProfilePicture getPictureByPersonalId(long id);

    Stream<ProfilePicture> getAllPictures();
}
