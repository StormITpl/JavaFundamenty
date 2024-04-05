package pl.stormit.jf.rental;

public class Car extends Equipment {
	private String name;
	private String brand;
	private CarType type;

	public Car(String id, String name, String brand, CarType type) {
		super(id);
		this.name = name;
		this.brand = brand;
		this.type = type;
	}
}
