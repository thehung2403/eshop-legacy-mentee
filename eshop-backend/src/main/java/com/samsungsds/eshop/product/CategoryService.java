package com.samsungsds.eshop.product;

import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class CategoryService {
	private final CategoryRepository categoryRepository;

	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public Iterable<Category> fetchAll() {
		return categoryRepository.findAll();
	}

	public Set<ProductCategory> fetchProductsById(final String id) {
		return categoryRepository.findById(id).get().getProductCategories();
	}

}