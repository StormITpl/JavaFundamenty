package pl.stormit.jf.rental;

public abstract class Equipment implements RentableItem {

	private String id;

	private Client reservedBy;

	private boolean available = true;

	public Equipment(String id) {
		this.id = id;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public Client getReservedBy() {
		return reservedBy;
	}

	@Override
	public boolean isAvailable() {
		return available;
	}

	@Override
	public void reserveItem(Client client) {
		// TODO validation...
		reservedBy = client;
		System.out.println(String.format("%s został zarezerwowany dla %s", id, client));
	}

	@Override
	public void rentItem(Client client) {
		available = false;
		System.out.println(String.format("%s został wypożyczony przez: %s", id, client));
	}

	@Override
	public String toString() {
		return getClass().getSimpleName()+"{" +
				"id='" + id + '\'' +
				'}';
	}
}
