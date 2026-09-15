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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Vec2 vec2 = (Vec2) o;
		return x == vec2.x && y == vec2.y;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}