package entities.model;

public class Product {

	private String name;
	private Double value;
	private Integer quantity;
	
	public Product(String name, Double value, Integer quantity) {
		this.name = name;
		this.value = value;
		this.quantity = quantity;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Double totalValue() {
		return value * quantity;
	}

	@Override
	public String toString() {
		return name + ", " + String.format("%.2f", totalValue());
	}
}
