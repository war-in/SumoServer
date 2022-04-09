package com.sumo.server.Database.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "Age_categories")
@Getter
@Setter
public class AgeCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "age_category_id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "oldest_competitor_birth_year")
    private LocalDate oldestCompetitorBirthYear;

    @Column(name = "youngest_competitor_birth_year")
    private LocalDate youngestCompetitorBirthYear;

    @ManyToOne
    @JoinColumn(name = "region")
    private Region region;

    @OneToMany(mappedBy = "ageCategory")
    private Set<Category> categories;

}
