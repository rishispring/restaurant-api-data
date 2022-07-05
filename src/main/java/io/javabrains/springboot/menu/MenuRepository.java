package io.javabrains.springboot.menu;
// https://spring.io/guides/gs/accessing-data-jpa/

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MenuRepository extends CrudRepository<Menu, String>{
	
//	@Query(value = "SELECT dishName, dishCategory, dishPrice"
//				  + "FROM menu"
//				  + "WHERE dishPrice BETWEEN low AND high")
	List<Menu> findByDishPriceBetween(int low, int high);	
	List<Menu> findByDishCategory(String dishCategory);
	List<Menu> findByDishCategoryAndDishPriceBetween(String dishCategory, int low, int high);
	
}

//public interface MenuRepository extends JpaRepository<Menu, String>{
//	
//	@Override
//	@Query(value = "SELECT u FROM menu dishName, dishCategory, dishPrice"
//				 + "FROM menu")
//	List<Menu> findAll();
//}
