package shapes;



public enum Direction8 {

	EAST(1, 0, "E"), NORTHEAST(1, -1, "NE"), NORTH(0, -1, "N"), NORTHWEST(-1, -1, "NW"), WEST(-1, 0, "W"),
	SOUTHWEST(-1, 1, "SW"), SOUTH(0, 1, "S"), SOUTHEAST(1, 1, "SE"), NONE(0, 0, "@"),;

	private final int dx;
	private final int dy;
	private String abbreviation;

	private Direction8(int dx, int dy, String abbreviation) {
		this.dx = dx;
		this.dy = dy;
		this.abbreviation = abbreviation;
	}
	
	public String getAbbreviation() {
		return abbreviation;
	}
	
	public int getDx() {
		return dx;
	}
	public int getDy() {
		return dy;
	}

}
