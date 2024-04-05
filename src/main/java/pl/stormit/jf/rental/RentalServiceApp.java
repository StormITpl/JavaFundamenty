package pl.stormit.jf.rental;

public class RentalServiceApp {

	public static void main(String[] args) {
		RentalService rentalService = new RentalService();

		Client client1 = new Client("Tomek", "Woliński", "L001");
		Client client2 = new Client("Jan", "Kowalski", "L002");

		Car car1 = new Car("C001", "Golf", "VW", CarType.COMPACT);
		Car car2 = new Car("C002", "Spider", "Ferrari", CarType.SPORT);

		Bicycle bicycle = new Bicycle("B011", BicycleType.MOUNTAIN);

		rentalService.addItem(car1);
		rentalService.addItem(car2);
		rentalService.addItem(bicycle);

		rentalService.reserveItem("C002", client1);
		rentalService.reserveItem("B011", client1);

		rentalService.rentItem("C002", client1);
		rentalService.rentItem("B011", client1);

		rentalService.rentItem("C001", client2);

		rentalService.returnItem("C002", client1);
		rentalService.returnItem("B011", client1);
		rentalService.returnItem("C001", client2);
	}
}
