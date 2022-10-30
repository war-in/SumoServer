package com.sumo.server.Database.CompetitionData.Category;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sumo.server.Database.CompetitionData.AgeCategory.AgeCategory;
import com.sumo.server.Database.CompetitionData.CategoryAtCompetition.CategoryAtCompetition;
import com.sumo.server.Database.CompetitionData.CompetitionDetails.CompetitionDetails;
import com.sumo.server.Database.StaticData.Sex.Sex;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "CATEGORIES")
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "CATEGORY_ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "AGE_CATEGORY_ID")
    private AgeCategory ageCategory;

    @Column(name = "WEIGHT_CATEGORY")
    private String weightCategory;

    @ManyToOne
    @JoinColumn(name = "SEX")
    private Sex sex;
}
