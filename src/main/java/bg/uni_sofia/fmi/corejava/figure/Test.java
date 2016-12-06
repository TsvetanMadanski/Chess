package bg.uni_sofia.fmi.corejava.figure;

public class Test {

	public static void main(String[] args) {
		Rook r = new Rook("White");
		Coord from = new Coord( 2, 5);
		Coord to = new Coord(2, 1);
		System.out.println(r.isValidMove(from, to));
		
	}

}
