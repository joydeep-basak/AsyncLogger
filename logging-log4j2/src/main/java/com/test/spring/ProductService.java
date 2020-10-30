package com.test.spring;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductService.class);
	
	
	@Override
	public List<Product> findAll() {
		long start = System.currentTimeMillis();
		logger.debug("Product Log Start from Log4j 2 ProductService entry");
//creating an object of ArrayList
		ArrayList<Product> products = new ArrayList<Product>();
//adding products to the List
		products.add(new Product(100, "Mobile", "CLK98123", 9000.00, 6));
		products.add(new Product(101, "Smart TV", "LGST09167", 60000.00, 3));
		products.add(new Product(102, "Washing Machine", "38753BK9", 9000.00, 7));
		products.add(new Product(103, "Laptop", "LHP29OCP", 24000.00, 1));
		products.add(new Product(104, "Air Conditioner", "ACLG66721", 30000.00, 5));
		products.add(new Product(105, "Refrigerator ", "12WP9087", 10000.00, 4));
		products.add(new Product(100, "Mobile", "CLK98123", 9000.00, 6));
		products.add(new Product(101, "Smart TV", "LGST09167", 60000.00, 3));
		products.add(new Product(102, "Washing Machine", "38753BK9", 9000.00, 7));
		
		logger.debug("Product Log Start from Log4j 2 ProductService Intermediate Step 1");
		
		products.add(new Product(103, "Laptop", "LHP29OCP", 24000.00, 1));
		products.add(new Product(104, "Air Conditioner", "ACLG66721", 30000.00, 5));
		products.add(new Product(105, "Refrigerator ", "12WP9087", 10000.00, 4));
		products.add(new Product(100, "Mobile", "CLK98123", 9000.00, 6));
		products.add(new Product(101, "Smart TV", "LGST09167", 60000.00, 3));
		products.add(new Product(102, "Washing Machine", "38753BK9", 9000.00, 7));
		products.add(new Product(103, "Laptop", "LHP29OCP", 24000.00, 1));
		products.add(new Product(104, "Air Conditioner", "ACLG66721", 30000.00, 5));
		products.add(new Product(105, "Refrigerator ", "12WP9087", 10000.00, 4));

		logger.debug("Product Log Start from Log4j 2 ProductService Intermediate Step 2");
		
		products.add(new Product(100, "Mobile", "CLK98123", 9000.00, 6));
		products.add(new Product(101, "Smart TV", "LGST09167", 60000.00, 3));
		products.add(new Product(102, "Washing Machine", "38753BK9", 9000.00, 7));
		products.add(new Product(103, "Laptop", "LHP29OCP", 24000.00, 1));
		products.add(new Product(104, "Air Conditioner", "ACLG66721", 30000.00, 5));
		products.add(new Product(105, "Refrigerator ", "12WP9087", 10000.00, 4));
		products.add(new Product(100, "Mobile", "CLK98123", 9000.00, 6));
		
		logger.debug("Product Log Start from Log4j 2 ProductService Intermediate Step 3");
		
		products.add(new Product(101, "Smart TV", "LGST09167", 60000.00, 3));
		products.add(new Product(102, "Washing Machine", "38753BK9", 9000.00, 7));
		products.add(new Product(103, "Laptop", "LHP29OCP", 24000.00, 1));
		products.add(new Product(104, "Air Conditioner", "ACLG66721", 30000.00, 5));
		products.add(new Product(105, "Refrigerator ", "12WP9087", 10000.00, 4));
		products.add(new Product(100, "Mobile", "CLK98123", 9000.00, 6));
		products.add(new Product(101, "Smart TV", "LGST09167", 60000.00, 3));
		products.add(new Product(102, "Washing Machine", "38753BK9", 9000.00, 7));
		products.add(new Product(103, "Laptop", "LHP29OCP", 24000.00, 1));
		products.add(new Product(104, "Air Conditioner", "ACLG66721", 30000.00, 5));
		products.add(new Product(105, "Refrigerator ", "12WP9087", 10000.00, 4));
//returns a list of product
	
		logger.debug("Product Log Start from Log4j 2 ProductService exit");
		logger.debug("Time to execute :: {}" , (System.currentTimeMillis() - start));
		return products;
	}
}
