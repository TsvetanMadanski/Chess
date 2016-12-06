package bg.uni_sofia.fmi.corejava.figure;

public class Pawn extends Figure {

	public Pawn(String color) {
		super(color);
	}

	@Override
	public boolean isValidMove(Coord from, Coord to) {
		
		if(from.getLetter() > 7 || from.getLetter() < 0 || from.getDigit() > 7  || from.getDigit() < 0) {
			return false;
		}
		
		if(to.getLetter() > 7 || to.getLetter() < 0 || to.getDigit() > 7  || to.getDigit() < 0) {
			return false;
		}
		
		if(this.color.equals("White")) {
			if(from.getLetter() == to.getLetter() && 
					(from.getDigit() - to.getDigit() == 1 || from.getDigit() - to.getDigit() == 2 )) {
				return true;
			}
			if((from.getLetter() - to.getLetter() == 1 || from.getLetter() - to.getLetter() == -1) 
					&& from.getDigit() - to.getDigit() == 1) {
				return true;
			}
			
		} else {
			if(from.getLetter() == to.getLetter() && 
					(from.getDigit() - to.getDigit() == -1 || from.getDigit() - to.getDigit() == -2 )) {
				return true;
			}
			if((from.getLetter() - to.getLetter() == 1 || from.getLetter() - to.getLetter() == -1) 
					&& from.getDigit() - to.getDigit() == -1) {
				return true;
			}
			
		}
		return false;
		
	}

	@Override
	public String getAbbreviation() {
		if(color.equals("White")) {
			return "WP";
		}
		return "BP";
	}

}
