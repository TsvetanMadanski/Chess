package bg.uni_sofia.fmi.corejava.figure;

public class Knight extends Figure {

	public Knight(String color) {

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

		if ((Math.abs(from.getLetter() - to.getLetter()) == 2 && Math.abs(from.getDigit() - to.getDigit()) == 1)
				|| (Math.abs(from.getLetter() - to.getLetter()) == 1
						&& Math.abs(from.getDigit() - to.getDigit()) == 2)) {
			return true;
		}
		
		return false;
	}

	@Override
	public String getAbbreviation() {
		if(color.equals("White")) {
			return "WH";
		}
		return "BH";
	}

}
