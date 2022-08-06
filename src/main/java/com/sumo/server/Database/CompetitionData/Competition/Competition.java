package com.sumo.server.Database.CompetitionData.Competition;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sumo.server.Database.CompetitionData.AgeCategory.AgeCategory;
import com.sumo.server.Database.CompetitionData.CompetitionDetails.CompetitionDetails;
import com.sumo.server.Database.CompetitionData.CompetitionType.CompetitionType;
import com.sumo.server.Database.StaticData.City.City;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "COMPETITIONS")
@Getter
@Setter
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "COMPETITION_ID")
    private long id;

    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "CITY_ID")
    private City city;

    @Column(name = "START_DATE")
    private LocalDate startDate;

    @Column(name = "END_DATE")
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "TYPE")
    private CompetitionType type;

    @OneToOne
    @JoinColumn(name = "COMPETITION_DETAILS_ID")
    private CompetitionDetails details;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Competition that = (Competition) o;
        return Objects.equals(getName(), that.getName()) && Objects.equals(getCity(), that.getCity()) && Objects.equals(getStartDate(), that.getStartDate()) && Objects.equals(getEndDate(), that.getEndDate()) && Objects.equals(getType(), that.getType()) && Objects.equals(getDetails(), that.getDetails());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCity(), getStartDate(), getEndDate(), getType(), getDetails());
    }
}
