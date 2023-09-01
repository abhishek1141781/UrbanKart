package com.app.services;

import java.util.List;
import java.util.Optional;

import com.app.dto.CatagoryDTO;
import com.app.entities.Categories;

public interface CategoryService {

	Categories  saveCategory(CatagoryDTO category);

	Optional<Categories> getCategory(Long CatId);

	List<Categories> getAllCategories();

	void deleteCategory(Long categoryId);

	

}
