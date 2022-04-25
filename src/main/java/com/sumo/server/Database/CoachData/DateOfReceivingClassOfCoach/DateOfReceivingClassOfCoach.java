package com.sumo.server.Database.CoachData.DateOfReceivingClassOfCoach;

import com.sumo.server.Database.CoachData.ClassOfCoach.ClassOfCoach;
import com.sumo.server.Database.CoachData.Coach.Coach;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "DATES_OF_RECEIVING_CLASSES_OF_COACHES")
@Getter
@Setter
public class DateOfReceivingClassOfCoach {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "DATE_OF_RECEIVING_CLASS_OF_COACH_ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "COACH_ID")
    private Coach coach;

    @ManyToOne
    @JoinColumn(name = "CLASS_OF_COACH_ID")
    private ClassOfCoach classOfCoach;

    @Column(name = "DATE_OF_RECEIVING")
    private LocalDate dateOfReceiving;
}
