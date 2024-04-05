package pl.stormit.jf;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {

	public static void main(String[] args) {
		char[][] board = {
				{' ', ' ', ' '},
				{' ', ' ', ' '},
				{' ', ' ', ' '}
		};

		printBoard(board);

		Scanner scanner = new Scanner(System.in);

		while(true) {
			playerMove(board, scanner);
			if(isGameFinished(board)){
				break;
			}

			computerMove(board);

			if(isGameFinished(board)){
				break;
			}

			printBoard(board);
		}

		scanner.close();
	}

	private static void computerMove(char[][] board) {
		Random random = new Random();

		while (true) {
			int computerMove = random.nextInt(9)+1; // <1; 9>

			if (isValidMove(board, computerMove)) {
				System.out.println("Komputer zagrał: " + computerMove);
				placeMove(board, Integer.toString(computerMove), 'O');
				break;
			}
		}
	}


	private static void playerMove(char[][] board, Scanner scanner) {
		System.out.println("Twój ruch (1-9)");

		while(true) {
			String userMove = scanner.nextLine();

			if (isValidMove(board, Integer.parseInt(userMove))) {
				placeMove(board, userMove, 'X');
				break;
			} else {
				System.out.println("Ruch niepoprawny");
			}
		}
	}

	private static void placeMove(char[][] board, String newMove, char symbol) {
		switch (newMove){
			case "1" :
				board[0][0] = symbol;
				break;
			case "2" :
				board[0][1] = symbol;
				break;
			case "3" :
				board[0][2] = symbol;
				break;
			case "4" :
				board[1][0] = symbol;
				break;
			case "5" :
				board[1][1] = symbol;
				break;
			case "6" :
				board[1][2] = symbol;
				break;
			case "7" :
				board[2][0] = symbol;
				break;
			case "8" :
				board[2][1] = symbol;
				break;
			case "9" :
				board[2][2] = symbol;
				break;
			default: {
				System.out.println("Niepoprawny ruch");
			}
		}
	}

	private static void printBoard(char[][] board) {
		System.out.println(board[0][0]+"|"+ board[0][1]+"|"+ board[0][2]);
		System.out.println("-+-+-");
		System.out.println(board[1][0]+"|"+ board[1][1]+"|"+ board[1][2]);
		System.out.println("-+-+-");
		System.out.println(board[2][0]+"|"+ board[2][1]+"|"+ board[2][2]);
	}

	private static boolean isValidMove(char[][] board, int position){
		return position>=1 && position <=9 && board[(position-1)/3][(position-1)%3] == ' ';
	}

	private static boolean isGameFinished(char[][] board){
		if(isWinning(board, 'X')){
			printBoard(board);
			System.out.println("Gracz wygrał");
			return true;
		}

		if(isWinning(board, 'O')){
			printBoard(board);
			System.out.println("Komputer wygrał");
			return true;
		}

		for(int i =0; i<3; i++){
			for(int j=1; j<3; j++){
				if(board[i][j] == ' '){
					return false;
				}
			}
		}

		printBoard(board);
		System.out.println("Remis");

		return true;
	}

	private static boolean isWinning(char[][] board, char symbol) {
		if(
						(board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol) ||
						(board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol) ||
						(board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol) ||

						(board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol) ||
						(board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol) ||
						(board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) ||

						(board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
						(board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)
		){
			return true;
		}

		return false;
	}
}
