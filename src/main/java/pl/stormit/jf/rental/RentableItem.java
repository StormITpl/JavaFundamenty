package pl.stormit.jf.rental;

public interface RentableItem {
	String getId();
	boolean isAvailable();
	Client getReservedBy();

	void reserveItem(Client client);

	void rentItem(Client client);
}
