package com.test.spring;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	@Autowired
	private IProductService productService;
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	// mapping the getProduct() method to /product
	@GetMapping(value = "/product")
	public List<Product> getProduct() {
		long start = System.currentTimeMillis();
		logger.debug("Product Log Start from Log4j 2 entry");
		// finds all the products
		List<Product> products = productService.findAll();
		// returns the product list
		logger.debug("Product Log end call from Log4j 2 exit");
		logger.debug("Time to execute :: {}" , (System.currentTimeMillis() - start));
		return products;
	}
}
