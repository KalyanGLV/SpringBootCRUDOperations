package com.ibm.demo.utils;
/*
 * 
 * kg972t
 */
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.ibm.demo.beans.Products;

@Component
public class Valiidation {
	
	public List<String> validate(Products product){
		
		List<String> required = new ArrayList<>();
		
		if(StringUtils.isEmpty(product.getProductId()))
			required.add("ProductId");
		
		if(StringUtils.isEmpty(product.getProductName()))
			required.add("ProductName");
		
		if(StringUtils.isEmpty(product.getProductDescription()))
			required.add("ProductDescription");
		
		return required;
		
	}

}
