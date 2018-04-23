package com.ibm.demo.controller;
/*
 * kg972t
 * 
 */

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ibm.demo.beans.Products;
import com.ibm.demo.processor.ProductProcessor;
import com.ibm.demo.service.ProductService;
import com.ibm.demo.utils.ProdcutException;

@Controller
public class ProductController {

	Logger log = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	ProductService productService;

	@Autowired
	ProductProcessor productProcessor;

	@RequestMapping(value = "/login/getProducts")
	public String getAllProduct(Model model) {
		log.info("in getAllProduct");
		List<Products> p = productService.getAllProducts();
		model.addAttribute("p", p);
		return "allProducts";

	}

	@RequestMapping(value = "/login/{id}/getProduct")
	public String getProduct(@PathVariable("id") String id, Model model) {
		log.info("in getProduct");
		Products p;
		try {
			p = productService.getProducts(id);
			model.addAttribute("p", p);
			return "editform";
		} catch (ProdcutException e) {
			String err = e.getMessage();
			model.addAttribute("errorDescr", err);
			return "er";
		}

	}

	@RequestMapping(value = "/login/{id}/deleteProduct")
	public String deleteProduct(@PathVariable("id") String id, Model model) {
		log.info("in deleteProduct");
		List<Products> p;
		try {
			p = productService.deleteProduct(id);
			model.addAttribute("p", p);
			return "allProducts";
		} catch (ProdcutException e) {
			String err = e.getMessage();
			model.addAttribute("errorDescr", err);
			return "er";
		}

	}

	@RequestMapping(value = "/login/deleteAllProducts")
	public String deleteAllProducts() {
		log.info("in deleteAllProducts");
		productService.deleteAllProduct();
		return "allProducts";

	}

	@RequestMapping(value = "/login/updateProduct")
	public String updateProduct(@RequestParam("pId") String pId, @RequestParam("pName") String pName,
			@RequestParam("pDescr") String pDescr, @RequestParam("pRelated") String pRelated,
			@RequestParam("pURL") String pURL, Model model) {
		log.info("in updateProduct");
		Products prod = productProcessor.setProducts(pId, pName, pDescr, pRelated, pURL);

		List<Products> p;
		try {
			p = productService.updateProduct(prod);
			model.addAttribute("p", p);
			return "allProducts";

		} catch (ProdcutException e) {
			String err = e.getMessage();
			model.addAttribute("errorDescr", err);
			return "er";
		}

	}

	@RequestMapping(value = "/login/addProduct")
	public String addProduct(@RequestParam("pId") String pId, @RequestParam("pName") String pName,
			@RequestParam("pDescr") String pDescr, @RequestParam("pRelated") String pRelated,
			@RequestParam("pURL") String pURL, Model model) {
		log.info("in addProduct");
		Products prod = productProcessor.setProducts(pId, pName, pDescr, pRelated, pURL);
		List<Products> p;
		try {
			p = productService.addProduct(prod);
			model.addAttribute("p", p);
			return "allProducts";
		} catch (ProdcutException e) {
			String err = e.getMessage();
			model.addAttribute("errorDescr", err);
			return "er";
		}

	}

	@RequestMapping(value = "/login/redirect")
	public String redirect() {
		return "addProduct";

	}

}
