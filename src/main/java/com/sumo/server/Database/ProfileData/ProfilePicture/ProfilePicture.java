package com.sumo.server.Database.ProfileData.ProfilePicture;

import com.sumo.server.Database.userData.PersonalDetails.PersonalDetails;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "PROFILE_PICTURES")
@Getter
@Setter
public class ProfilePicture {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "PROFILE_PICTURE_ID")
    private String id;
    private String name;
    private String type;

    @OneToOne
    @JoinColumn(name = "PERSONAL_DETAILS_ID")
    private PersonalDetails personalDetails;

    @Lob
    @Column(name = "FILE_DATA")
    private byte[] data;

    public ProfilePicture(String fileName, String contentType, byte[] bytes) {
        this.name = fileName;
        this.type = contentType;
        this.data = bytes;
    }

    public ProfilePicture() {

    }
}
