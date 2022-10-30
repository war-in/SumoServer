package com.sumo.server.Database.CompetitionData.Category;

import com.sumo.server.Database.CompetitionData.AgeCategory.AgeCategory;
import com.sumo.server.Database.StaticData.Sex.Sex;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();

    List<AgeCategory> getAllAgeCategories();

    List<Category> getCategoriesForSexAndAge(AgeCategory ageCategory, Sex sex);

    AgeCategory getAgeCategoryById(Long id);
}
