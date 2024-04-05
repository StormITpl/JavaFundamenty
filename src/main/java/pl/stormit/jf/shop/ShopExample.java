package pl.stormit.jf.shop;

import java.util.List;

class Shop {

	public void order(Order order, Seller seller) {
		System.out.println(String.format("Order: %s from: %s, totalAmount:  %.2f zł", order.getClient().getName(), seller.getName(), order.totalAmount()/100.0));
	}
}

abstract class Person {
	private String name;

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
} 

class Client extends Person {
	public Client(String name) {
		super(name);
	}
}

class Seller extends Person {
	public Seller(String name) {
		super(name);
	}
}

class Product {

	private String name;
	private int price;

	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public int getPrice() {
		return price;
	}
}

class Order {

	private List<Product> products;
	private Client client;

	public Order(List<Product> products, Client client) {
		this.products = products;
		this.client = client;
	}

	public Client getClient() {
		return client;
	}

	public int totalAmount() {
		return products.stream().map(Product::getPrice).reduce(0, Integer::sum);
	}
}

public class ShopExample {
	public static void main(String[] args) {
		/**
		 * Klient Tomek przychodzi do sklepu i kupuje 2 chleby, 4 bułki, mleko oraz jajka.
		 * Obsługuje go ekspedientka Magdalena.
		 */

		/**
		 * Klienta Łucja kupuje 4 pączki i sok pomarańczowy. Obsługuje ją ekspedient Marek
		 */

		Shop shop = new Shop();
		
		Client client1 = new Client("Tomek");
		Client client2 = new Client("Łucja");
		Seller seller1 = new Seller("Magdalena");
		Seller seller2 = new Seller("Marek");

		Order order1 = new Order(
				List.of(new Product("Bread", 455), new Product("Bread", 455),
						new Product("Roll", 170), new Product("Roll", 170), new Product("Roll", 170), new Product("Roll", 170),
						new Product("Milk", 350),
						new Product("Eggs", 1200)
				), client1
		);
		
		shop.order(order1, seller1);

		Order order2 = new Order(
				List.of(new Product("Donut", 270), new Product("Donut", 270), new Product("Donut", 270), new Product("Donut", 270),
						new Product("Orange joice", 1200)),
				client2
		);
		shop.order(order2, seller2);
	}
}
