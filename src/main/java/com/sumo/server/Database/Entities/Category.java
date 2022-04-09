package com.sumo.server.Database.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "Categories")
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "age_category_id")
    private AgeCategory ageCategory;

    @Column(name = "weight_category")
    private int weightCategory;

    @ManyToOne
    @JoinColumn(name = "sex")
    private Sex sex;

    @Column(name = "date")
    private LocalDate date;

    @OneToMany(mappedBy = "category")
    private Set<CategoryAtCompetition> categoriesAtCompetition;
}
