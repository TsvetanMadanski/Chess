package bg.uni_sofia.fmi.corejava.figure;

public class Coord {
	private int digit;
	private int letter;

	public Coord(int digit, int letter) {
		this.digit = digit;
		this.letter = letter;

	}

	public int getDigit() {
		return digit;
	}

	public void setDigit(int digit) {
		this.digit = digit;
	}

	public int getLetter() {
		return letter;
	}

	public void setLetter(int letter) {
		this.letter = letter;
	}

}
