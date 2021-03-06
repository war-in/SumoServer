package com.sumo.server.Database.ESFAdminData.ESFAdmin;

import com.sumo.server.Database.ESFAdminData.PeriodOfOffice.PeriodOfOffice;
import com.sumo.server.Database.userData.PersonalDetails.PersonalDetails;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "ESF_ADMINS")
@Getter
@Setter
public class ESFAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ESF_ADMIN_ID")
    private long id;

    @OneToOne
    @JoinColumn(name = "PERSONAL_DETAILS_ID")
    private PersonalDetails personalDetails;
}
