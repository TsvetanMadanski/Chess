package bg.uni_sofia.fmi.corejava.game;

import java.util.Scanner;

import bg.uni_sofia.fmi.corejava.board.Board;
import bg.uni_sofia.fmi.corejava.figure.Coord;
import bg.uni_sofia.fmi.corejava.figure.Figure;

public class Game {

	public static void main(String[] args) {

		Board board = new Board();
		board.showBoard();
		boolean checkmate = false;
		String turn = "White";

		while (!checkmate) {
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			System.out.println("Enter a row from:");
			int row = input.nextInt();
			System.out.println("Enter col from:");
			int col = input.nextInt();
			Coord from = new Coord(row, col);

			System.out.println("Enter row to:");
			row = input.nextInt();
			System.out.println("Enter col to:");
			col = input.nextInt();
			Coord to = new Coord(row, col);

			Figure figure = board.getBoard()[from.getDigit()][from.getLetter()];
			System.out.println(board.moveFigure(figure, from, to, turn, checkmate));
			board.showBoard();

			if (turn.equals("White")) {
				turn = "Black";
			} else {
				turn = "White";
			}

			if (checkmate) {
				System.out.println("Checkmate");
			}
		}

	}

}
