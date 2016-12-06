package bg.uni_sofia.fmi.corejava.figure;

public class Queen extends Figure {

	public Queen(String color) {
		super(color);
	}

	@Override
	public boolean isValidMove(Coord from, Coord to) {
		if (from.getLetter() > 7 || from.getLetter() < 0 || from.getDigit() > 7 || from.getDigit() < 0) {
			return false;
		}

		if (to.getLetter() > 7 || to.getLetter() < 0 || to.getDigit() > 7 || to.getDigit() < 0) {
			return false;
		}

		int letter = Math.abs(from.getLetter() - to.getLetter());
		int digit = Math.abs(from.getDigit() - to.getDigit());

		if (letter == digit || letter == 0 || digit == 0) {
			return true;
		}
		return false;
	}

	@Override
	public String getAbbreviation() {

		if (color.equals("White")) {
			return "WQ";
		}
		return "BQ";
	}

}
