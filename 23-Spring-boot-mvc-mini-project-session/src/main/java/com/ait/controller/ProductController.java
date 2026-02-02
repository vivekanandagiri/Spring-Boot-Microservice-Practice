package com.ait.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.ait.dto.ProductDTO;
import com.ait.service.ProductService;
import com.ait.util.ProductType;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping(value = "/")
	public String getRegistrationPage(Model model,HttpSession session, RedirectAttributes redirectAttributes) {
		String user = (String) session.getAttribute("user");
		if(user !=null) {
		model.addAttribute("product", new ProductDTO());
		model.addAttribute("type", ProductType.values());
		return "register";
		}
		
		else {
			redirectAttributes.addFlashAttribute("errorMessage", "Invalid session. Please try to login again.");
            return "redirect:/login";
			
		}
	}
	
	@PostMapping(value = "/register" ,name = "register the product")
	public String saveProduct(@ModelAttribute("product")ProductDTO product,Model model,HttpSession session,RedirectAttributes redirectAttributes) {
		String user = (String) session.getAttribute("user");
		if(user !=null) {
		 ProductDTO registerProduct = productService.registerProduct(product);
		 redirectAttributes.addFlashAttribute("msg", "Product Registered Successfully ! ! "+registerProduct.getId());
		return "redirect:/list_product";
		}
		else {
			redirectAttributes.addFlashAttribute("errorMessage", "Invalid session. Please try to login again.");
            return "redirect:/login";
			
		}
		
	}
	
	@GetMapping(value =  "/list_product")
	public String getListOfProduct(Model model ,HttpSession session,RedirectAttributes redirectAttributes) {
		String user = (String) session.getAttribute("user");
		if(user !=null) {
		List<ProductDTO> allProduct=productService.fetchAllProduct();
		model.addAttribute("listProduct",allProduct);
		return"listproduct";
		}
		else {
			redirectAttributes.addFlashAttribute("errorMessage", "Invalid session. Please try to login again.");
            return "redirect:/login";
			
		}
	}
	
	@GetMapping(value = "/delete/{id}")
	
	public String deleteProduct(@PathVariable("id")Long id,HttpSession session,RedirectAttributes redirectAttributes) {
		String user = (String) session.getAttribute("user");
		if(user !=null) {
		productService.deleteProduct(id);
		redirectAttributes.addFlashAttribute("msg", "Product Deleted  Successfully ! ! ");
		return "redirect:/list_product";
		}
		else {
			redirectAttributes.addFlashAttribute("errorMessage", "Invalid session. Please try to login again.");
            return "redirect:/login";
			
		}
		
		
	}
	@GetMapping(value = "/edit/{id}")
	public String editProduct(@PathVariable("id")Long id,Model model,HttpSession session, RedirectAttributes redirectAttributes) {
		
		String user = (String) session.getAttribute("user");
		if(user !=null) {
		ProductDTO ProductById = productService.fetchProductById(id);
		
		LocalDate mfd = ProductById.getMfd();
		
		DateTimeFormatter formatedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		// for if else 
		//String inputformatedDate=(mfd != null) ? mfd.format(formatedDate) : ""; 
		//or
		String inputformatedDate;
	    if (mfd != null) {
	        inputformatedDate = mfd.format(formatedDate);
	    } else {
	        inputformatedDate = "";
	    }
	    
		System.out.println(inputformatedDate);
		model.addAttribute("product", ProductById);
		model.addAttribute("inputmfd", inputformatedDate);
		model.addAttribute("type", ProductType.values());
		
		return "edit";
		}
		else {
			redirectAttributes.addFlashAttribute("errorMessage", "Invalid session. Please try to login again.");
            return "redirect:/login";
			
		}
	}
	@PostMapping(value = "update")
	public String updateProduct(@ModelAttribute("product")ProductDTO product,Model model,HttpSession session,RedirectAttributes redirectAttributes) {
		String user = (String) session.getAttribute("user");
		if(user !=null) {
		ProductDTO updatedProduct = productService.updateProduct(product);
		redirectAttributes.addFlashAttribute("msg", "Product Updated  Successfully ! ! "+"[Product id:"+updatedProduct.getId()+"]");
		return "redirect:/list_product";
		}
		else {
			redirectAttributes.addFlashAttribute("errorMessage", "Invalid session. Please try to login again.");
            return "redirect:/login";
			
		}
		
	}

}
