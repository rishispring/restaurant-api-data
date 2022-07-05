package io.javabrains.springboot.menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springboot.menu.responses.Response;

@RestController
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	@RequestMapping(
			value = {"/allItems"},
			method = RequestMethod.GET)
	public List<Menu> getAllItems(){
		return menuService.getAllItems();
	}
	
	@RequestMapping(
			value = { "/allItems/{lowPrice}/{highPrice}" },
			method=RequestMethod.GET)
	@ResponseBody
	public List<Menu> getAllItemsBetween(
			@PathVariable("lowPrice") int lowPrice,
			@PathVariable("highPrice") int highPrice){
		
		return menuService.getAllItemsBetween(lowPrice, highPrice);
	}
	
	@RequestMapping(
			value = {"/{itemCategory}"},
			method=RequestMethod.GET)
	@ResponseBody
	public List<Menu> getItems(@PathVariable String itemCategory){
		return menuService.getItems(itemCategory);
	}
	
	@RequestMapping(
			value = { "/{itemCategory}/{lowPrice}/{highPrice}" }, 
			method=RequestMethod.GET)
	@ResponseBody
	public List<Menu> getItemsBetween(
			@PathVariable String itemCategory,
			@PathVariable int lowPrice,
			@PathVariable int highPrice){
		
		return menuService.getItemsBetween(itemCategory, lowPrice, highPrice);
		
	}	

	@RequestMapping(value = "/allItems", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Response> addItems(@RequestBody Menu menu){		
		// allow only items with valid dishCategories & valid prices
		return menuService.addItem(menu);
	}
	
	@RequestMapping(value = "/allItems", method=RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Response> updateItems(@RequestBody Menu menu) {
		return menuService.updateItem(menu);
	}
	
	@RequestMapping(value = "/allItems", method=RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<Response> deleteItems(@RequestBody Menu menu) {
		return menuService.deleteItem(menu);
	}
	
}




//int lowPrice = lowPriceOptional.orElse(Integer.MIN_VALUE);
//int highPrice = highPriceOptional.orElse(Integer.MAX_VALUE);

//@EnableScheduling
//@Scheduled(fixedRate = 1000)
//public void SpringConfig() {
//	System.out.println(
//			"Fixed delay task : " + System.currentTimeMillis() / 1000);
//}


//@RequestMapping(value = "/{itemCategory}/{itemId}/", method=RequestMethod.POST)
//@ResponseBody
//public void addItems(
//		@PathVariable("itemCategory") String itemCategory, 
//		@PathVariable("itemId") String itemId, 
//		Menu menu){
////	System.out.println("Hello rishi");
//	menuService.addItem(menu);
//}

//@RequestMapping(value="/all_items/", method=RequestMethod.GET)
//@ResponseBody
//public String getAllItems() {
//	return "Hello there!!!";
//}
//
//@RequestMapping(value="/all_items//wow", method=RequestMethod.GET)
//@ResponseBody
//public String getAllItemsWow() {
//	return "Hello there wow!!!";
//}