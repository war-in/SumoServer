package com.sumo.server.Database.ProfileData.ProfilePicture;

import com.sumo.server.Database.userData.PersonalDetails.PersonalDetails;
import com.sumo.server.Database.userData.PersonalDetails.PersonalDetailsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ProfilePictureServiceImpl implements ProfilePictureService {
    private final ProfilePictureRepository profilePictureRepository;
    private final PersonalDetailsRepository personalDetailsRepository;

    @Override
    public ProfilePicture save(MultipartFile file, long personalDetailsId) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        ProfilePicture profilePicture = new ProfilePicture(fileName, file.getContentType(), file.getBytes());
        PersonalDetails personalDetails = personalDetailsRepository.findPersonalDetailsById(personalDetailsId);
        profilePicture.setPersonalDetails(personalDetails);

        return profilePictureRepository.save(profilePicture);
    }

    @Override
    public ProfilePicture getPicture(String id) {
        return profilePictureRepository.getById(id);
    }

    @Override
    public ProfilePicture getPictureByPersonalId(long id) {
        return profilePictureRepository.getProfilePictureByPersonalDetailsId(id);
    }

    @Override
    public Stream<ProfilePicture> getAllPictures() {
        return profilePictureRepository.findAll().stream();
    }

}
