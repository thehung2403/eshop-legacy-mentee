package com.samsungsds.eshop.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api; //👈👈  add line
import io.swagger.annotations.ApiOperation; //👈👈  add line

@RestController
@RequestMapping(value = "/api/products")
@Api(tags = "상품", description = "상품 관련 API") //👈👈  add line
public class ProductController {
  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping
  @ApiOperation(value = "상품 조회") //👈👈  add line
  public ResponseEntity<Products> fetchProducts(@RequestParam(value = "ids", required = false) String ids) {
    Products products = null;
    if (ids == null || ids.isEmpty()) {
      try {
        products = productService.fetchProducts();
      } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(products);
      }
      return ResponseEntity.ok(products);
    } else {
      String[] itemIds = ids.split(",");
      products = productService.fetchProductsByIds(itemIds);
      return ResponseEntity.ok(products);
    }
  }

  @GetMapping(value = "/{id}")
  @ApiOperation(value = "id로 상품 조회") //👈👈  add line
  public ResponseEntity<Product> fetchProductsByIds(@PathVariable("id") String id) {
    Product product = productService.fetchProductById(id);
    return ResponseEntity.ok(product);
  }
}