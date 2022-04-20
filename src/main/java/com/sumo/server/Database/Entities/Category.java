package com.sumo.server.Database.Entities;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "AGE_CATEGORY_ID")
    private AgeCategory ageCategory;

    @Column(name = "WEIGHT_CATEGORY")
    private int weightCategory;

    @ManyToOne
    @JoinColumn(name = "SEX")
    private Sex sex;

    @Column(name = "DATE")
    private LocalDate date;

    @OneToMany(mappedBy = "category")
    private Set<CategoryAtCompetition> categoriesAtCompetition = new LinkedHashSet<>();
}
