package com.sumo.server.Database.ProfileData.ProfilePicture;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfilePictureRepository extends JpaRepository<ProfilePicture, String> {
    ProfilePicture getProfilePictureByPersonalDetailsId(long id);
}
