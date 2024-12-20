package iuh.fit.se.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import iuh.fit.se.entities.Product;
import iuh.fit.se.services.CategoryService;
import iuh.fit.se.services.ProductService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;
	@GetMapping("")
	public String showAllScreen(Model model) {
		model.addAttribute("listProducts", productService.findAll());
		model.addAttribute("listCategories", categoryService.findAll());
		return "list";
	}
	@GetMapping("/search")
	public String searchScreen(@RequestParam(name = "category", required = false) String category, @RequestParam(name = "isActive", required = false) String isActive, @RequestParam(name = "subDays", required = false) int subDate,Model model) {
		System.out.println("category: "+category + " isActive:"+isActive + " period:"+subDate);
		model.addAttribute("listProducts", productService.findProductByCategoryOrIsActiveOrRegisterDate(category, isActive, subDate));
		model.addAttribute("listCategories", categoryService.findAll());
		return "list";
	}
	@GetMapping("/save/{id}")
	public String saveScreen(@PathVariable("id") int id,Model model) {
		Product product = null;
		if(id==0) {
			product = new Product();
			product.setId(id);
		} else {
			product = productService.findById(id);
		}
		model.addAttribute("product", product);
		model.addAttribute("listCategories", categoryService.findAll());
		return "save";
	}
	@PostMapping("/remove/{id}")
	public String removeAction(@PathVariable("id") int id,Model model) {
		//TODO: process POST request
		productService.remove(id);
		return "redirect:/products";
	}
	@PostMapping("/save")
	public String removeAction(@ModelAttribute(name = "product") @Valid Product product, BindingResult bindingResult, Model model) {
		System.out.println(product);
		if(bindingResult.hasErrors()) {
			model.addAttribute("product", product);
			model.addAttribute("listCategories", categoryService.findAll());
			return "save";
		}
		try {
			if(product.getId()==0) {
				productService.save(product);
			}
			else {
				productService.update(product.getId(), product);
			}
		} catch (Exception e) {
			// TODO: handle exception
			bindingResult.rejectValue("code", "error.code", e.getMessage());
			model.addAttribute("product", product);
			model.addAttribute("listCategories", categoryService.findAll());
			return "save";
		}
		return "redirect:/products";
	}
	
}
