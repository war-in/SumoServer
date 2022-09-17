package com.sumo.server.Database.CompetitionData.AgeCategory;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sumo.server.Database.CompetitionData.Category.Category;
import com.sumo.server.Database.CompetitionData.CompetitionDetails.CompetitionDetails;
import com.sumo.server.Database.StaticData.Region.Region;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
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

    @ManyToMany(mappedBy = "ageCategories")
    //@JsonIgnoreProperties("ageCategories")
    List<CompetitionDetails> competitionDetails = new ArrayList<>();
}
