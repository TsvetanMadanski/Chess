package bg.uni_sofia.fmi.corejava.game;

import bg.uni_sofia.fmi.corejava.figure.Coord;
import bg.uni_sofia.fmi.corejava.figure.Figure;
import bg.uni_sofia.fmi.corejava.figure.King;
import bg.uni_sofia.fmi.corejava.figure.Pawn;

public class MoveValidator {

	public static final int BOARD_SIZE = 8;

	public static boolean isClearPath(Figure[][] board, Figure f, Coord fromSquare, Coord toSquare) {
		String iterationType = typeOfIteration(fromSquare, toSquare);
		switch (iterationType) {
		case "Diagonally":
			if (diagonalIteration(board, f, fromSquare, toSquare)) {
				return true;
			}
			break;
		case "LeftOrRight":
			if (leftOrRightIteration(board, f, fromSquare, toSquare)) {
				return true;
			}
			break;
		case "UpOrDown":
			if (upOrDownIteration(board, f, fromSquare, toSquare)) {
				return true;
			}
			break;
		case "GShape":
			if (gShapeIteration(board, f, fromSquare, toSquare)) {
				return true;
			}
			break;

		}
		return false;
	}

	private static boolean gShapeIteration(Figure[][] board, Figure f, Coord fromSquare, Coord toSquare) {
		int toX = toSquare.getLetter();
		int toY = toSquare.getDigit();

		if (board[toY][toX] == null || !board[toY][toX].getColor().equals(f.getColor())) {
			return true;
		}
		return false;
	}

	private static boolean upOrDownIteration(Figure[][] board, Figure f, Coord fromSquare, Coord toSquare) {
		int letter = fromSquare.getLetter() - toSquare.getLetter();
		int digit = fromSquare.getDigit() - toSquare.getDigit();
		int fromY = fromSquare.getDigit();
		int toX = toSquare.getLetter();
		int toY = toSquare.getDigit();

		if (letter != 0)
			return false;

		if (digit < 0) {
			int indexX = toX;
			for (int indexY = fromY + 1; indexY <= toY - 1; indexY++) {
				if (board[indexY][indexX] != null) {
					return false;
				}
			}
			if (board[toY][toX] == null) {
				return true;
			} else {
				if (board[toY][toX].getColor().equals(f.getColor())) {
					return false;
				} else {
					if (f instanceof Pawn) {
						return false;
					}
					return true;
				}
			}
		} else {
			int indexX = toX;
			for (int indexY = fromY - 1; indexY >= toY + 1; indexY--) {
				if (board[indexY][indexX] != null) {
					return false;
				}
			}
			if (board[toY][toX] == null) {
				return true;
			} else {
				if (board[toY][toX].getColor().equals(f.getColor())) {
					return false;
				} else {
					if (f instanceof Pawn) {
						return false;
					}
					return true;
				}
			}
		}
	}

	private static boolean leftOrRightIteration(Figure[][] board, Figure f, Coord fromSquare, Coord toSquare) {
		int letter = fromSquare.getLetter() - toSquare.getLetter();
		int digit = fromSquare.getDigit() - toSquare.getDigit();
		int fromX = fromSquare.getLetter();
		int toX = toSquare.getLetter();
		int toY = toSquare.getDigit();

		if (digit != 0)
			return false;

		if (letter < 0) {
			int indexY = toY;
			for (int indexX = fromX + 1; indexX <= toX - 1; indexX++) {
				if (board[indexY][indexX] != null) {
					return false;
				}
			}
			if (board[toY][toX] == null) {
				return true;
			} else {
				if (board[toY][toX].getColor().equals(f.getColor())) {
					return false;
				} else {
					return true;
				}
			}
		} else {
			int indexY = toY;
			for (int indexX = fromX - 1; indexX >= toX + 1; indexX--) {
				if (board[indexY][indexX] != null) {
					return false;
				}
			}
			if (board[toY][toX] == null) {
				return true;
			} else {
				if (board[toY][toX].getColor().equals(f.getColor())) {
					return false;
				} else {
					return true;
				}
			}
		}
	}

	private static boolean diagonalIteration(Figure[][] board, Figure f, Coord fromSquare, Coord toSquare) {
		int letter = fromSquare.getLetter() - toSquare.getLetter();
		int digit = fromSquare.getDigit() - toSquare.getDigit();
		int fromX = fromSquare.getLetter();
		int fromY = fromSquare.getDigit();
		int toX = toSquare.getLetter();
		int toY = toSquare.getDigit();

		if (letter < 0 && digit < 0) {
			int indexY = fromY + 1;
			int indexX;
			for (indexX = fromX + 1; indexX <= toX - 1; indexX++) {
				if (board[indexY][indexX] != null) {
					return false;
				}
				indexY++;
			}
			if (board[toY][toX] == null) {
				return true;
			} else {
				if (board[toY][toX].getColor().equals(f.getColor())) {
					return false;
				} else {
					return true;
				}
			}
		}

		if (letter < 0 && digit > 0) {
			int indexY = fromY - 1;
			int indexX;
			for (indexX = fromX + 1; indexX <= toX - 1; indexX++) {
				if (board[indexY][indexX] != null) {
					return false;
				}
				indexY--;
			}
			if (board[toY][toX] == null) {
				return true;
			} else {
				if (board[toY][toX].getColor().equals(f.getColor())) {
					return false;
				} else {
					return true;
				}
			}
		}

		if (letter > 0 && digit < 0) {
			int indexY = fromY + 1;
			int indexX;
			for (indexX = fromX - 1; indexX >= toX + 1; indexX--) {
				if (board[indexY][indexX] != null) {
					return false;
				}
				indexY++;
			}
			if (board[toY][toX] == null) {
				return true;
			} else {
				if (board[toY][toX].getColor().equals(f.getColor())) {
					return false;
				} else {
					return true;
				}
			}
		}

		else {
			int indexY = fromY - 1;
			int indexX;
			for (indexX = fromX - 1; indexX >= toX + 1; indexX--) {
				if (board[indexY][indexX] != null) {
					return false;
				}
				indexY--;
			}
			if (board[toY][toX] == null) {
				return true;
			} else {
				if (board[toY][toX].getColor().equals(f.getColor())) {
					return false;
				} else {
					return true;
				}
			}
		}

	}

	private static String typeOfIteration(Coord fromSquare, Coord toSquare) {
		int letter = fromSquare.getLetter() - toSquare.getLetter();
		int digit = fromSquare.getDigit() - toSquare.getDigit();

		if (Math.abs(letter) == Math.abs(digit)) {
			return "Diagonally";
		}
		if (Math.abs(letter) > 0 && digit == 0) {
			return "LeftOrRight";
		}
		if (letter == 0 & Math.abs(digit) > 0) {
			return "UpOrDown";
		}
		if (Math.abs(letter) == 1 && Math.abs(digit) == 2 || (Math.abs(letter) == 2 && Math.abs(digit) == 1)) {
			return "GShape";
		}
		return "IncorrectPattern";
	}

	private static Coord getMyKingPosition(Figure[][] board, String color) {
		for (int row = 0; row < BOARD_SIZE; row++) {
			for (int col = 0; col < BOARD_SIZE; col++) {
				if (board[row][col] instanceof King && board[row][col].getColor().equals(color)) {
					return new Coord(row, col);
				}
			}
		}
		return null;
	}

	@SuppressWarnings("unused")
	private static Coord getOpponentKingPosition(Figure[][] board, String color) {
		for (int row = 0; row < BOARD_SIZE; row++) {
			for (int col = 0; col < BOARD_SIZE; col++) {
				if (board[row][col] instanceof King && !board[row][col].getColor().equals(color)) {
					return new Coord(row, col);
				}
			}
		}
		return null;
	}

	public static boolean putInCheck(Figure[][] board, String color) {
		Coord myKingPosition = getMyKingPosition(board, color);
		if (myKingPosition == null) {
			throw new NullPointerException();
		}

		if (color.equals("White")) {
			color = "Black";
		} else {
			color = "White";
		}

		for (int row = 0; row < BOARD_SIZE; row++) {
			for (int col = 0; col < BOARD_SIZE; col++) {
				Figure f = board[row][col];
				Coord from = new Coord(row, col);
				if (f != null && f.getColor().equals(color) && f.isValidMove(from, myKingPosition)
						&& isClearPath(board, f, from, myKingPosition)) {
					return true;
				}

			}
		}

		return false;

	}

}
