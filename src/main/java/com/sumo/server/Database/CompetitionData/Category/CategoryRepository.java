package com.sumo.server.Database.CompetitionData.Category;

import com.sumo.server.Database.CompetitionData.AgeCategory.AgeCategory;
import com.sumo.server.Database.StaticData.Sex.Sex;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findAllBy();

    List<Category> findAllByAgeCategoryAndSex(AgeCategory ageCategory, Sex sex);
}
