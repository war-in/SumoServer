package com.sumo.server.Database.ESFAdminData.PeriodOfOffice;

import com.sumo.server.Database.ESFAdminData.ESFAdmin.ESFAdmin;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "PERIODS_OF_OFFICE")
@Getter
@Setter
public class PeriodOfOffice {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "PERIOD_OF_OFFICE_ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "ESF_ADMIN_ID")
    private ESFAdmin esfAdmin;

    @Column(name = "START_DATE")
    private LocalDate start;

    @Column(name = "END_DATE")
    private LocalDate end;
}
