package pl.stormit.jf.prs;

import pl.stormit.jf.prs.GameCommand;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PRSApplication {

	public static void main(String[] args) {
		System.out.println("Welcome to the GAME!");

		Scanner scanner = new Scanner(System.in);

		while (true) {
			try {
				String line = scanner.nextLine();
				GameCommand command = GameCommand.of(line);
				GameCommand pcCommand = pcCommand();

				if (command == GameCommand.QUITE) {
					System.out.println("Quite game");
					break;
				}

				if (isDraw(command, pcCommand)) {
					System.out.println("Draw");
				} else if (isFirstWin(command, pcCommand)) {
					System.out.println("You win!!");
				} else {
					System.out.println("You lose...");
				}

				System.out.println(String.format("command => %s, pc => %s", command, pcCommand));

			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private static boolean isFirstWin(GameCommand a, GameCommand b) {
		return a == GameCommand.PAPER && b == GameCommand.ROCK
				|| a == GameCommand.ROCK && b == GameCommand.SCISSORS
				|| a == GameCommand.SCISSORS && b == GameCommand.PAPER;
	}

	private static boolean isDraw(GameCommand a, GameCommand b) {
		return a == b;
	}

	private static GameCommand pcCommand() {
		List<GameCommand> allowedCommands = Arrays.asList(GameCommand.PAPER, GameCommand.ROCK,
				GameCommand.SCISSORS);

		return allowedCommands.get(getRandomNumber(0, 3)); // <0, 3)
	}

	static int getRandomNumber(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}
}
