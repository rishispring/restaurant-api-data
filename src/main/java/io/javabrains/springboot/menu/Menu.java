package io.javabrains.springboot.menu;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

// This part basically like table properties of database
// Save topic instances in the database table 
// with instance variables as columns
// with objects as rows
@Entity
@Table(name = "menu")
public class Menu {
	
	@Id
//	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy="uuid")
	@Column(name = "dishName")
	private String dishName;
	
	@Column(name = "dishCategory")
	private String dishCategory;
	
	@Column(name = "dishPrice")
	private int dishPrice;
	
	public Menu() {}

	public Menu(String dishName, String dishCategory, int dishPrice) {
		super();
		this.dishName = dishName;
		this.dishCategory = dishCategory;
		this.dishPrice = dishPrice;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public String getDishCategory() {
		return dishCategory;
	}

	public void setDishCategory(String dishCategory) {
		this.dishCategory = dishCategory;
	}

	public int getDishPrice() {
		return dishPrice;
	}

	public void setDishPrice(int dishPrice) {
		this.dishPrice = dishPrice;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dishCategory, dishName, dishPrice);
	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Menu other = (Menu) obj;
//		return Objects.equals(dishCategory, other.dishCategory) && Objects.equals(dishName, other.dishName)
//				&& dishPrice == other.dishPrice;
//	}

	
	
		
}
