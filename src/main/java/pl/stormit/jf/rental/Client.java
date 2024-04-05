package pl.stormit.jf.rental;

public class Client {

	private String name;
	private String surname;
	private String licenseNumber;

	public Client(String name, String surname, String licenseNumber) {
		this.name = name;
		this.surname = surname;
		this.licenseNumber = licenseNumber;
	}

	@Override
	public String toString() {
		return "Client{" +
				"licenseNumber='" + licenseNumber + '\'' +
				'}';
	}
}
