package com.sumo.server.Database.Entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "AGE_CATEGORIES")
@Data
public class AgeCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
