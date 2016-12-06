package bg.uni_sofia.fmi.corejava.board;

import bg.uni_sofia.fmi.corejava.figure.Bishop;
import bg.uni_sofia.fmi.corejava.figure.Coord;
import bg.uni_sofia.fmi.corejava.figure.Figure;
import bg.uni_sofia.fmi.corejava.figure.King;
import bg.uni_sofia.fmi.corejava.figure.Knight;
import bg.uni_sofia.fmi.corejava.figure.Pawn;
import bg.uni_sofia.fmi.corejava.figure.Queen;
import bg.uni_sofia.fmi.corejava.figure.Rook;
import bg.uni_sofia.fmi.corejava.game.MoveValidator;


public class Board {
	private Figure[][] board;
	public static final int BOARD_SIZE = 8;

	public Board() {
		board = new Figure[BOARD_SIZE][BOARD_SIZE];
		board[0][0] = new Rook("Black");
		board[0][1] = new Knight("Black");
		board[0][2] = new Bishop("Black");
		board[0][3] = new Queen("Black");
		board[0][4] = new King("Black");
		board[0][5] = new Bishop("Black");
		board[0][6] = new Knight("Black");
		board[0][7] = new Rook("Black");

		for (int i = 0; i < 8; i++) {
			board[1][i] = new Pawn("Black");
		}

		int rows = 2, cols = 0;

		while (rows < 6) {
			while (cols < 8) {
				board[rows][cols] = null;
				cols++;
			}
			cols = 0;
			rows++;
		}

		for (int i = 0; i < 8; i++) {
			board[6][i] = new Pawn("White");
		}

		board[7][0] = new Rook("White");
		board[7][1] = new Knight("White");
		board[7][2] = new Bishop("White");
		board[7][3] = new Queen("White");
		board[7][4] = new King("White");
		board[7][5] = new Bishop("White");
		board[7][6] = new Knight("White");
		board[7][7] = new Rook("White");

	}

	public Figure[][] getBoard() {
		return board;
	}

	private Figure[][] getCopyOfBoard() {
		Figure[][] copyOfBoard = new Figure[BOARD_SIZE][BOARD_SIZE];
		for (int row = 0; row < BOARD_SIZE; row++) {
			for (int col = 0; col < BOARD_SIZE; col++) {
				copyOfBoard[row][col] = board[row][col];
			}
		}
		return copyOfBoard;
	}

	public String moveFigure(Figure f, Coord fromSquare, Coord toSquare, String turn, boolean isInCheck) {

		if (this.board[fromSquare.getDigit()][fromSquare.getLetter()] == null) {
			return "false";
		}

		if (!f.isValidMove(fromSquare, toSquare) || !turn.equals(f.getColor())
				|| !MoveValidator.isClearPath(this.board, f, fromSquare, toSquare)) {
			return "false";
		}

		Figure[][] copyOfBoard = getCopyOfBoard();
		moveAndEat(copyOfBoard, fromSquare, toSquare);
		if (MoveValidator.putInCheck(copyOfBoard, turn)) {
			return "Can not leave king in check";
		}
		copyOfBoard = getCopyOfBoard();
		

		moveAndEat(this.board, fromSquare, toSquare);
		return "true";
	}

	private static void moveAndEat(Figure[][] board, Coord fromSquare, Coord toSquare) {
		
		Figure temp = board[fromSquare.getDigit()][fromSquare.getLetter()];
		board[fromSquare.getDigit()][fromSquare.getLetter()] = board[toSquare.getDigit()][toSquare.getLetter()];
		board[toSquare.getDigit()][toSquare.getLetter()] = temp;
		if (board[fromSquare.getDigit()][fromSquare.getLetter()] != null) {
			board[fromSquare.getDigit()][fromSquare.getLetter()] = null;
		}
	}

	

	public void showBoard() {
		System.out.println("-----------------------------------------");

		for (int row = 0; row < BOARD_SIZE; row++) {

			for (int column = 0; column < BOARD_SIZE; column++) {
				if (board[row][column] != null) {
					System.out.print("| " + board[row][column].getAbbreviation() + " ");
					if (column + 1 == BOARD_SIZE) {
						System.out.print("|");
					}
				} else {
					System.out.print("| " + " " + "  ");
					if (column + 1 == BOARD_SIZE) {
						System.out.print("|");
					}
				}

			}
			System.out.println("");
			System.out.println("-----------------------------------------");
		}
	}

}
