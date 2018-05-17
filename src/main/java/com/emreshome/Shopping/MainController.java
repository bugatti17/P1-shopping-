package com.emreshome.Shopping;

import java.awt.ItemSelectable;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.emreshome.Shopping.Entity.Product;
import com.emreshome.Shopping.Entity.User;
import com.emreshome.Shopping.Service.CartUtil;
import com.emreshome.Shopping.Service.ProductService;
import com.emreshome.Shopping.Service.UserService;
import com.emreshome.Shopping.model.Cart;
import com.emreshome.Shopping.model.ProductInCart;
import com.emreshome.Shopping.model.ProductInfo;
import com.emreshome.Shopping.repositories.UserRepository;

@Controller
public class MainController {
	 
	 @Autowired 
	 private ProductService productService;
	
	 @Autowired 
	 private UserService userService;
	
	
	 public boolean isAuthenticated(){

	       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	       return authentication != null && !(authentication instanceof AnonymousAuthenticationToken) && authentication.isAuthenticated();

	   }
	@RequestMapping(value = "/",method=RequestMethod.GET)
	public String hello(ModelMap model){
		
		 if(isAuthenticated()){
			  Object userDetails = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			  User u=userService.findByUsername(((org.springframework.security.core.userdetails.User)userDetails).getUsername());
			  model.addAttribute("realname", u.getName());
		  }	
		  
		return "index";
	}
	
	@RequestMapping(value = "/list",method=RequestMethod.GET)
	public String list(ModelMap model) {
		List<Product> P=productService.findAll();
	
		 if(isAuthenticated()){
			  Object userDetails = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			  User u=userService.findByUsername(((org.springframework.security.core.userdetails.User)userDetails).getUsername());
			  model.addAttribute("realname", u.getName());
		  }	
		  
		  model.addAttribute("items", P);
		return "list";
	}
	@RequestMapping(value = "/manager",method=RequestMethod.POST)
	public String list(ModelMap model, @ModelAttribute Product product){
		product.setCreateDate(new java.sql.Date(System.currentTimeMillis()));
		productService.save(product);
		return "redirect:/list";
		
	}
	
	@RequestMapping(value = "/add",method=RequestMethod.POST)
	public String addProduct(HttpServletRequest request,ModelMap model,
			@RequestParam(value="id",defaultValue="") Long id,
			@RequestParam("quantity") int q){
		if(id>0 && q>=1){
			Cart myCart = CartUtil.getCartInSession(request);
			
			 myCart.addProduct(productService.findById(id),q);
		}
		else{
			//TODO
			System.out.println("error");
		}
		
		return "redirect:/list";
	}

	@RequestMapping(value = "/delete",method=RequestMethod.GET)
	public String deleteProduct(HttpServletRequest request,ModelMap model,
			@RequestParam(value="id",defaultValue="") Long id){
		if(id>0){
			Cart myCart = CartUtil.getCartInSession(request);
			
			 myCart.deleteProduct(productService.findById(id));
		}
		
		return "redirect:/myCard";
	}
	
	@RequestMapping(value = "/manager",method=RequestMethod.GET)
	public String manager(ModelMap model) {
		List<Product> P=productService.findAll();
		for(Product p:P){
			System.out.println(p.toString());
			
		}
	
		model.addAttribute("items", P);
		return "manager";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(Model model, String error, String logout){
		 if (error != null){
	            model.addAttribute("error", "Your username or password is invalid.");
	            
	            return "login";
		 }
		 if (logout != null){
	            model.addAttribute("message", "You have been logged out successfully.");
	            return "login";
		 }
		
		 return "login";
	     
		
	}
	@RequestMapping(value="/editProduct", method = RequestMethod.GET)
	public String editProduct(HttpServletRequest request,ModelMap model,@RequestParam(value="id", defaultValue="") Long id){
		model.addAttribute("item", productService.findById(id));
		return "edit-admin";
	}
	@RequestMapping(value="/editProduct", method = RequestMethod.POST)
	public String editSaveProduct(HttpServletRequest request,ModelMap model,
			@ModelAttribute Product product){
		System.out.println(product.getId());
		Product del=productService.findById(product.getId());
		product.setCreateDate(del.getCreateDate());
		productService.delete(del);
		productService.save(product);
		return "redirect:/list";
	}
	@RequestMapping(value="/myCard", method = RequestMethod.GET)
	public String myCard(HttpServletRequest request,Model model){
		Cart myCart = CartUtil.getCartInSession(request);
		 for(ProductInCart p:myCart.getProducts())
			 System.out.println(p.getPrice());
			 model.addAttribute("items", myCart.getProducts());
		return "mycart";
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/login?logout";
	}
}
