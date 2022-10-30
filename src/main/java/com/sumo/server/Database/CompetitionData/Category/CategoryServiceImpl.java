package com.sumo.server.Database.CompetitionData.Category;

import com.sumo.server.Database.CompetitionData.AgeCategory.AgeCategory;
import com.sumo.server.Database.CompetitionData.AgeCategory.AgeCategoryRepository;
import com.sumo.server.Database.StaticData.Sex.Sex;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    final CategoryRepository categoryRepository;
    final AgeCategoryRepository ageCategoryRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAllBy();
    }

    @Override
    public List<AgeCategory> getAllAgeCategories() {
        return ageCategoryRepository.findAllBy();
    }

    @Override
    public List<Category> getCategoriesForSexAndAge(AgeCategory ageCategory, Sex sex) {
        return categoryRepository.findAllByAgeCategoryAndSex(ageCategory, sex);
    }

    @Override
    public AgeCategory getAgeCategoryById(Long id) {
        return ageCategoryRepository.getAgeCategoryById(id);
    }
}
