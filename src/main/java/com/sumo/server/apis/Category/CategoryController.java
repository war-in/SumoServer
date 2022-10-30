package com.sumo.server.apis.Category;

import com.sumo.server.Database.CompetitionData.AgeCategory.AgeCategory;
import com.sumo.server.Database.CompetitionData.Category.Category;
import com.sumo.server.Database.CompetitionData.Category.CategoryService;
import com.sumo.server.Database.StaticData.Sex.Sex;
import com.sumo.server.Database.StaticData.Sex.SexService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    final CategoryService categoryService;
    final SexService sexService;

    @GetMapping()
    public ResponseEntity<List<Category>> getCategories() {
        return ResponseEntity.ok().body(categoryService.getAll());
    }

    @GetMapping("/ageCategory")
    public ResponseEntity<List<AgeCategory>> getAgeCategories() {
        return ResponseEntity.ok().body(categoryService.getAllAgeCategories());
    }

    @GetMapping("/weightCategoriesForSexAndAge")
    public ResponseEntity<List<Category>> getWeightCategories(@RequestParam long ageCategoryId,@RequestParam String sex ) {
        Sex sexFromDb = sexService.findSexByName(sex);
        AgeCategory ageCategory = categoryService.getAgeCategoryById(ageCategoryId);
        return ResponseEntity.ok().body(categoryService.getCategoriesForSexAndAge(ageCategory,sexFromDb));
    }

}
