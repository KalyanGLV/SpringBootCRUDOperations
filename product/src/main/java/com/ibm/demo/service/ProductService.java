package com.ibm.demo.service;
/*
 * 
 * 
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.demo.beans.Products;
import com.ibm.demo.processor.ProductProcessor;
import com.ibm.demo.utils.ProdcutException;

@Service
public class ProductService {

	@Autowired
	ProductProcessor productProcessor;

	public List<Products> getAllProducts() {
		return productProcessor.getAllProducts();

	}

	public Products getProducts(String id) throws ProdcutException {
		return productProcessor.getProduct(id);

	}

	public List<Products> updateProduct(Products product) throws ProdcutException {
		List<Products> p = productProcessor.updateProduct(product);
		return p;

	}

	public List<Products> deleteProduct(String id) throws ProdcutException {
		return productProcessor.deleteProduct(id);

	}

	public String deleteAllProduct() {
		return productProcessor.deleteAllProduct();

	}

	public List<Products> addProduct(Products product) throws ProdcutException {
		return productProcessor.addProduct(product);

	}

}