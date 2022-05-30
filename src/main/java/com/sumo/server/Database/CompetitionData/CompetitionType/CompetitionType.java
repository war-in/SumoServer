package com.sumo.server.Database.CompetitionData.CompetitionType;

import com.sumo.server.Database.CompetitionData.Competition.Competition;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "COMPETITION_TYPES")
@Getter
@Setter
public class CompetitionType {

    @Id
    @Column(name = "TYPE")
    private String type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompetitionType that = (CompetitionType) o;
        return Objects.equals(getType(), that.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType());
    }
}
