package com.app.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.ProductUpdateDTO;
import com.app.dto.ProductsDTO;
import com.app.entities.Products;
import com.app.entities.projections.ProductsProjection;
import com.app.services.ImageHandlingService;
import com.app.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService productService;

	@Autowired
	private ImageHandlingService imageService;

	@PostMapping
	public ResponseEntity<?> saveProduct(@RequestBody ProductsDTO product) {
		return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
	}
//URL : http://localhost:8080/products/{productId}
//    @DeleteMapping("/{productId}") 
//    public ResponseEntity<?> deleteProduct(@PathVariable Long productId)
//    {
//        productService.deleteProduct(productId);
//
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
	// URL : http://localhost:8080/products/

	@GetMapping
	public ResponseEntity<?> getAllProducts() {
		return new ResponseEntity<>(productService.findAllProducts(), HttpStatus.OK);
	}

	@PutMapping("/{productId}")
	public ResponseEntity<?> updateProduct(@PathVariable Long productId, @RequestBody ProductUpdateDTO product) {
		productService.updateProduct(product, productId);
		return new ResponseEntity<>("Product Updated", HttpStatus.CREATED);
	}

	@GetMapping(value = "/category/{categoryId}")
	public ResponseEntity<List<ProductsProjection>> getProductsByCategory1(@PathVariable Long categoryId) {

		return new ResponseEntity<List<ProductsProjection>>(productService.getProductsByCategory(categoryId),
				HttpStatus.CREATED);
	}

	@DeleteMapping("/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable Long productId) {
		productService.deleteProduct(productId);

		return new ResponseEntity<>("Product Deleted", HttpStatus.OK);
	}

//    @DeleteMapping("category/{categoryId}") 
//    public ResponseEntity<String> deleteProductByCategory(@PathVariable Long categoryId)
//    {
//    	productService.deleteProductByCategory(categoryId);
//
//    	return new ResponseEntity<>("Products of Category deleted",HttpStatus.OK);
//    }

	@GetMapping("/{productId}")
	public Products getProductById(@PathVariable Long productId) {

		return productService.getProductById(productId);
	}

	// Add REST end point to upload image
	// URL : http://host:port/products/{productId}/image , Method=POST
	@PostMapping(value = "/{productId}/image")
	public ResponseEntity<?> uploadImageToServerSideFolder(@RequestParam MultipartFile imageFile,
			@PathVariable Long productId) throws IOException {
		System.out.println("in upload img " + productId + " " + imageFile.getOriginalFilename());
		return new ResponseEntity<>(imageService.uploadImage(productId, imageFile), HttpStatus.CREATED);
	}

	// Add REST end point to download/serve image , method=GET
	// URL : http://host:port/products/{productId}/image
	@GetMapping(value = "/{productId}/image", produces = { MediaType.IMAGE_GIF_VALUE, MediaType.IMAGE_JPEG_VALUE,
			MediaType.IMAGE_PNG_VALUE })
	public ResponseEntity<?> serveImageFromServerSideFolder(@PathVariable Long productId) throws IOException {
		System.out.println("in serve img " + productId);
		return new ResponseEntity<>(imageService.serveImage(productId), HttpStatus.OK);
	}

}
