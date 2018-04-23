package com.ibm.demo.processor;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibm.demo.beans.Products;
import com.ibm.demo.utils.ProdcutException;
import com.ibm.demo.utils.Valiidation;

@Component
public class ProductProcessor {

	Logger log = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	Valiidation valiidation;

	Map<String, Products> productsMap = new LinkedHashMap<>();

	Products p1 = new Products("1", "AVPN", "AVPN Service", "AVPN Dedicated,MIS", "image");
	Products p2 = new Products("2", "MIS", "MIS Service", "AVPN,AVPN Dedicated", "image");
	Products p3 = new Products("3", "AVPN Dedicated", "AVPN Dedicated Service", "MIS,AVPN", "image");

	public ProductProcessor() {
		productsMap.put(p1.getProductId(), p1);
		productsMap.put(p2.getProductId(), p2);
		productsMap.put(p3.getProductId(), p3);
	}

	public List<Products> getAllProducts() {
		log.info("in getAllProducts");
		List<Products> productsList = new ArrayList<>();
		productsMap.forEach((s, p) -> {
			productsList.add(p);
		});
		return productsList;

	}

	public Products getProduct(String id) throws ProdcutException {
		log.info("in getProduct");
		boolean isValid = isExist(id);
		if (isValid)
			return productsMap.get(id);
		else
			throw new ProdcutException("01", "Invalid Product ID:Please enter a valid Product Id");

	}

	public List<Products> updateProduct(Products product) throws ProdcutException {
		log.info("in updateProduct ");
		boolean isValid = isExist(product.getProductId());
		if (isValid) {
			productsMap.replace(product.getProductId(), product);
			return getAllProducts();
		} else
			throw new ProdcutException("01", "Invalid Product ID:Please enter a valid Product Id");

	}

	public List<Products> deleteProduct(String id) throws ProdcutException {
		log.info("in deleteProduct");
		boolean isValid = isExist(id);
		if (isValid) {
			productsMap.remove(id);
			return getAllProducts();
		} else
			throw new ProdcutException("01", "Invalid Product ID:Please enter a valid Product Id");

	}

	public String deleteAllProduct() {
		log.info("in deleteAllProduct");
		productsMap.clear();
		return "Deleted successfully";

	}

	public List<Products> addProduct(Products product) throws ProdcutException {
		log.info("in addProduct");
		List<String> required = valiidation.validate(product);
		StringBuilder error = new StringBuilder("Required Data Missing: ");
		if (!required.isEmpty())

		{
			required.stream().forEach(s -> {
				error.append(s);
				error.append(",");
			});

			error.deleteCharAt(error.length() - 1);

			throw new ProdcutException("01", error.toString());
		}
		productsMap.put(product.getProductId(), product);
		return getAllProducts();

	}

	public boolean isExist(String prodId) {
		boolean exist = false;

		for (String id : productsMap.keySet()) {
			if (prodId.equalsIgnoreCase(id))
				exist = true;

		}
		return exist;

	}

	public Products setProducts(String productId, String productName, String productDescription, String relatedProducts,
			String productImage) {
		log.info("in setProducts");
		Products prod = new Products();
		prod.setProductId(productId);
		prod.setProductName(productName);
		prod.setProductDescription(productDescription);
		prod.setRelatedProducts(relatedProducts);
		prod.setProductImage(productImage);
		return prod;

	}

}