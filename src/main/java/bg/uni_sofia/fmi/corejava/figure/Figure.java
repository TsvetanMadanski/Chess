package bg.uni_sofia.fmi.corejava.figure;

public abstract class Figure {
	
	protected String color;
	
	public Figure(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
	
	public abstract boolean isValidMove(Coord from, Coord to);
	public abstract String getAbbreviation();
}
