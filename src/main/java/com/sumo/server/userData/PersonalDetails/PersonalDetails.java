package com.sumo.server.userData.PersonalDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PERSONAL_DETAILS")
public class PersonalDetails {
    @Id
    @Column(name = "PERSONAL_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

//    to complete
}
