package com.samsungsds.eshop.product;

import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/categories")
public class CategoryController {

	private final CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@GetMapping(value = "")
	public ResponseEntity<Iterable<Category>> fetchAllCategories() {
		return ResponseEntity.ok(categoryService.fetchAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Set<ProductCategory>> fetchProductsById(@PathVariable("id") String id) {
		return ResponseEntity.ok(categoryService.fetchProductsById(id));
	}
}