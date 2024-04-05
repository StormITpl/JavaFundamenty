package pl.stormit.jf.rental;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RentalService {

	private List<RentableItem> inventory;

	public RentalService() {
		inventory = new ArrayList<>();
	}

	public void rentItem(String itemId, Client client) {
		for(var item : inventory){
			if(Objects.equals(itemId, item.getId())){
				// znaleźliśmy obiekt

				// czy jest dostępny
				if(!item.isAvailable()){
					System.out.println(String.format("%s jest już wypożyczony", item.getId()));
					return;
				}

				// czy jest zarezerwowany dla innej osoby?
				if(item.getReservedBy()!=null && !Objects.equals(client, item.getReservedBy())){
					System.out.println(String.format("%s jest już zarezerwowany przez: %s", item.getId(), item.getReservedBy()));
					return;
				}

				item.rentItem(client);
				return;
			}
		}

		System.out.println("Brak takiego sprzętu do wypożyczenia "+itemId);
	}

	public void addItem(RentableItem item) {
		System.out.println("Dodajemy sprzęt: "+item);
		inventory.add(item);
	}

	public void reserveItem(String itemId, Client client) {
		for(var item : inventory){
			if(Objects.equals(itemId, item.getId())){
				// znaleźliśmy obiekt

				// czy jest zarezerwowany?
				if(item.getReservedBy()!=null){
					System.out.println(String.format("%s jest już zarezerwowany przez: %s", item.getId(), item.getReservedBy()));
					return;
				}

				// czy jest dostępny
				if(!item.isAvailable()){
					System.out.println(String.format("%s jest już wypożyczony", item.getId()));
					return;
				}

				item.reserveItem(client);
				return;
			}
		}

		System.out.println("Brak takiego sprzętu do rezerwacji "+itemId);
	}

	public void returnItem(String itemId, Client client) {
		System.out.println(client+" zwrócił "+itemId);
	}
}
