package dnt.freshvote.web;


import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dnt.freshvote.domain.Product;
import dnt.freshvote.domain.User;
import dnt.freshvote.repositories.ProductRepository;
import lombok.Data;

@Data
@Controller
public class ProductController {
	
	@Autowired
	private ProductRepository productRepo;
	
	@GetMapping("/products")
	public String getProducts(ModelMap model)  {
		return "product";
	}
	
	@GetMapping("/products/{productId}")
	public String getProduct(@PathVariable Long productId, ModelMap model, HttpServletResponse respone) throws IOException {
		Optional<Product> productOpt = productRepo.findById(productId);
		if (productOpt.isPresent()) {
			model.put("product", productOpt.get());
		}
		else {
			respone.sendError(HttpStatus.NOT_FOUND.value(), "Product with id " + productId + " is not found.");
		}
		return "product";
	}
	
	@PostMapping("/products/{productId}")
	public String saveProduct(@PathVariable Long productId, Product product) {
		productRepo.save(product);
		return "redirect:/products/" + product.getId();
	}
	
	@PostMapping("/products")
	public String createProduct(@AuthenticationPrincipal User user) {
		Product product = new Product();
		product.setUser(user);
		product.setPublished(false);
		product = productRepo.save(product);
		return "redirect:/products/" + product.getId();
	}
}
