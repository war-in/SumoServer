package com.sumo.server.Database.RefereeData.DateOfReceivingClassOfReferee;

import com.sumo.server.Database.CoachData.ClassOfCoach.ClassOfCoach;
import com.sumo.server.Database.CoachData.Coach.Coach;
import com.sumo.server.Database.RefereeData.ClassOfReferee.ClassOfReferee;
import com.sumo.server.Database.RefereeData.Referee.Referee;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "DATES_OF_RECEIVING_CLASSES_OF_REFEREES")
@Getter
@Setter
public class DateOfReceivingClassOfReferee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "DATE_OF_RECEIVING_CLASS_OF_REFEREE_ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "REFEREE_ID")
    private Referee referee;

    @ManyToOne
    @JoinColumn(name = "CLASS_OF_REFEREE_ID")
    private ClassOfReferee classOfReferee;

    @Column(name = "DATE_OF_RECEIVING")
    private LocalDate dateOfReceiving;
}
