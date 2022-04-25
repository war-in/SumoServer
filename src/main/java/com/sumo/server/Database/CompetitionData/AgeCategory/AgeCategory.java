package com.sumo.server.Database.CompetitionData.AgeCategory;

import com.sumo.server.Database.CompetitionData.Category.Category;
import com.sumo.server.Database.StaticData.Region.Region;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "AGE_CATEGORIES")
@Setter
@Getter
public class AgeCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "AGE_CATEGORY_ID")
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "OLDEST_COMPETITOR_BIRTH_YEAR")
    private LocalDate oldestCompetitorBirthYear;

    @Column(name = "YOUNGEST_COMPETITOR_BIRTH_YEAR")
    private LocalDate youngestCompetitorBirthYear;

    @ManyToOne
    @JoinColumn(name = "REGION")
    private Region region;

    @OneToMany(mappedBy = "ageCategory")
    private Set<Category> categories = new LinkedHashSet<>();

}
