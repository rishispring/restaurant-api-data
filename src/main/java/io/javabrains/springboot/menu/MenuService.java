package io.javabrains.springboot.menu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.javabrains.springboot.menu.responses.Response;

@Service
public class MenuService {
	
	public static ArrayList<String> dishCategories = new ArrayList<String>();
	static {
		MenuService.dishCategories.add(new String("vegItems"));
		MenuService.dishCategories.add(new String("nonVegItems"));
	}
	
	@Autowired
	private MenuRepository menuRepository;
	
	public ResponseEntity<Response> addItem(Menu item){

		if (!MenuService.dishCategories.contains(item.getDishCategory())) {
			Response errorResponse = new Response("Error : Invalid Dish Category", 400, 
					item.getDishName(), item.getDishCategory(), item.getDishPrice());
			return ResponseEntity.badRequest().body(errorResponse);
			
		}
		else if(!(item.getDishPrice() > 0)){
			Response errorResponse = new Response("Error : Dish price should be positive", 400, 
					item.getDishName(), item.getDishCategory(), item.getDishPrice());
			return ResponseEntity.badRequest().body(errorResponse);
		}
		else if(item.getDishName().equals(new String(""))) {
			Response errorResponse = new Response("Error : Invalid dish name", 400, 
					item.getDishName(), item.getDishCategory(), item.getDishPrice());
			return ResponseEntity.badRequest().body(errorResponse);
		}
		else if(menuRepository.existsById(item.getDishName())) {
			Response errorResponse = new Response("Error : Dish name already exists", 400, 
					item.getDishName(), item.getDishCategory(), item.getDishPrice());
			return ResponseEntity.badRequest().body(errorResponse);
		}
		else {
			menuRepository.save(item);
			Response successResponse = new Response("Success : Item posted", 200, 
					item.getDishName(), item.getDishCategory(), item.getDishPrice());
			return ResponseEntity.ok(successResponse);
		}
	}
	
	public ResponseEntity<Response> updateItem(Menu item) {
		
//		{
//			"ipId":"200",
//			"profileId":"B0bpi4lbo7c575",
//			"contractIds":["B0bpi6h6e6r585"],
//			"shopIds":["25997"],
//			"statusMessage":"SUCCESS",
//			"statusCode":"01"
//		}
		Response putResponse = new Response();
		putResponse.setDishName(item.getDishName());
		putResponse.setDishCategory(item.getDishCategory());
		putResponse.setDishPrice(item.getDishPrice());
		
		if(!MenuService.dishCategories.contains(item.getDishCategory())) {
			putResponse.setStatus("Error : Invalid dish category");
			putResponse.setStatusCode(400);
			return ResponseEntity.badRequest().body(putResponse);
		}
		else if(!(item.getDishPrice() > 0)) {
			putResponse.setStatus("Error : Invalid dish price");
			putResponse.setStatusCode(400);
			return ResponseEntity.badRequest().body(putResponse);
		}
		else if(!menuRepository.existsById(item.getDishName())) {
			putResponse.setStatus("Error : Dish name not exists");
			putResponse.setStatusCode(400);
			return ResponseEntity.badRequest().body(putResponse);
		}
		else {
			menuRepository.save(item);
			putResponse.setStatus("Success : Item updated");
			putResponse.setStatusCode(200);
			return ResponseEntity.ok(putResponse);
		}
	}
	
	public ResponseEntity<Response> deleteItem(Menu item) {
		
		Menu check = menuRepository.findById(item.getDishName()).orElse(null);
//		System.out.println("Check is : " + check.toString());
//		System.out.println("Item is : " + item.toString());
//		System.out.println("Decision is : " + item.equals(check));
		
		Response delResponse = new Response();
		delResponse.setDishName(item.getDishName());
		delResponse.setDishCategory(item.getDishCategory());
		delResponse.setDishPrice(item.getDishPrice());
		
		if(item.equals(null)) {
			delResponse.setStatus("Error : Invalid menu to delete");
			delResponse.setStatusCode(400);
			return ResponseEntity.badRequest().body(delResponse);
		}
		else if (!item.equals(check)) {
			delResponse.setStatus("Error : No such menu to delete");
			delResponse.setStatusCode(400);
			return ResponseEntity.badRequest().body(delResponse);
		}
		else {
			menuRepository.delete(item);
			delResponse.setStatus("Success : Item deleted");
			delResponse.setStatusCode(200);
			return ResponseEntity.ok(delResponse);
		}
	}
	
	public List<Menu> getAllItems(){
		
//		Menu dummyItem = new Menu("Panneer", "vegItems", 300);
//		menuRepository.save(dummyItem);
		
		List<Menu> items = new ArrayList<Menu>();
		menuRepository.findAll().forEach(items::add);
		return items;
	}
	
	public List<Menu> getAllItemsBetween(int low, int high){
		return menuRepository.findByDishPriceBetween(low, high);
	}
	
	public List<Menu> getItems(String itemCategory){
		return menuRepository.findByDishCategory(itemCategory);
	}
	
	public List<Menu> getItemsBetween(String itemCategory, int low, int high){
		return menuRepository.findByDishCategoryAndDishPriceBetween(itemCategory, low, high);
	}
	
	
	
}
