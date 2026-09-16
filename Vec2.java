public class Vec2 {

	private int x;
	private int y;

	public Vec2() {
		this(0, 0);
	}

	public Vec2(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Vec2 add(Vec2 other) {
		return new Vec2(this.x + other.x, this.y + other.y);
	}

	public boolean equalsVec(Vec2 other) {
		return this.x == other.x && this.y == other.y;
	}
	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}