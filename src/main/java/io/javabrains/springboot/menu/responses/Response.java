package io.javabrains.springboot.menu.responses;

public class Response {
	
	private String status;
	private int statusCode;
	private String dishName;
	private String dishCategory;
	private int dishPrice;
	
	public Response() {
		
	}
	public Response(String status, int statusCode, String dishName, String dishCategory, int dishPrice) {
		super();
		this.status = status;
		this.statusCode = statusCode;
		this.dishName = dishName;
		this.dishCategory = dishCategory;
		this.dishPrice = dishPrice;
	}
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Response [status=" + status + ", statusCode=" + statusCode + ", dishName=" + dishName + ", dishCategory=" + dishCategory
				+ ", dishPrice=" + dishPrice + "]";
	}
	
	
}
