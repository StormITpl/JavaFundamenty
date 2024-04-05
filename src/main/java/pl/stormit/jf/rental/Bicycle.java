package pl.stormit.jf.rental;

public class Bicycle extends Equipment {

	private BicycleType type;

	public Bicycle(String id, BicycleType type) {
		super(id);
		this.type = type;
	}
}
