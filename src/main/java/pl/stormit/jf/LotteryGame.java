package pl.stormit.jf;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class LotteryGame {

	public static void main(String[] args) {
		// komputer wylosuje 6 liczb losowych
		List<Integer> winningNumbers = new ArrayList<>();
		Random random = new Random();

		for (int i = 0; i < 6; i++) {
			while (true) {
				Integer winningNumber = random.nextInt(49) + 1; // <1, 49>
				if (!winningNumbers.contains(winningNumber)) {
					winningNumbers.add(winningNumber);
					break;
				}
			}
		}
		System.out.println("Komputer wylosował => " + winningNumbers);

		// użytkownik zgaduje 6 liczb
		System.out.println("Zagrajmy w grę! :)");
		System.out.println("Podaj 6 liczb od 1 do 49");

		Scanner scanner = new Scanner(System.in);

		List<Integer> userNumbers = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			while (true) {
				try {
					String userLine = scanner.nextLine();

					Integer userNumber = Integer.parseInt(userLine);
					if (userNumber >= 1 && userNumber <= 49) {
						userNumbers.add(userNumber);
						break;
					} else {
						System.out.println("Niepoprawna liczba. Podaj liczbę z zakresu od 1 do 49");
					}
				} catch (Exception e) {
					System.out.println("To nawet nie jest liczba");
				}
			}
		}

		scanner.close();

		// sprawdzamy czy wygrał i ile liczb pasuje
		System.out.println("Komputer wylosował => " + winningNumbers);
		System.out.println("Użytkownik podał => " + userNumbers);

		userNumbers.retainAll(winningNumbers);

		System.out.println("Odgadnięte numery to => " + userNumbers);

		if (userNumbers.containsAll(winningNumbers)) {
			System.out.println("Gratuluję wygranej!!");
		} else {
			System.out.println("Niestety, nie tym razem.");
		}
	}
}
