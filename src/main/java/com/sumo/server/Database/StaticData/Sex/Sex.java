package com.sumo.server.Database.StaticData.Sex;

import com.sumo.server.Database.CompetitionData.Category.Category;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "SEXES")
@Getter
@Setter
public class Sex {

    @Id
    @Column(name = "SEX")
    private String sex;

    @OneToMany(mappedBy = "sex")
    private Set<Category> categories = new LinkedHashSet<>();
}
