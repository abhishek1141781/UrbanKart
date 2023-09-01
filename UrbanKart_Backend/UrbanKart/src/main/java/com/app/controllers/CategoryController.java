package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CatagoryDTO;
import com.app.services.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping (consumes = "application/json")
    public ResponseEntity<?> saveCategory(@RequestBody CatagoryDTO category)
    {
		System.out.println("In Category");
        return new ResponseEntity<>(categoryService.saveCategory(category), HttpStatus.CREATED);
    }
	
	@GetMapping
	public ResponseEntity<?> getAllCategories()
    {
        return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.CREATED);
    }
//	
//	@DeleteMapping("/{categoryId}") 
//    public ResponseEntity<?> deleteCategory(@PathVariable Long categoryId)
//    {
//		
//		categoryService.deleteCategory(categoryId);
//
//    	return new ResponseEntity<>(HttpStatus.OK);
//    }
	
	

}
