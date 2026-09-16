
// Projectile #2
public class Arrow extends Projectile {

	public Arrow(Vec2 position, Vec2 direction) {
		super(position, direction, 1, 2);
	}

	@Override
	public String toString() {
		String symbol = "◁";
		if (direction.getX() == 1) symbol = "▷";
		else if (direction.getX() == -1) symbol = "◁";
		else if (direction.getY() == 1) symbol = "▽";
		else if (direction.getY() == -1) symbol = "△";
		return Color.PURPLE + symbol + Color.RESET;
	}

}
