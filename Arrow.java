
// Projectile #2
public class Arrow extends Projectile {

	public Arrow(Vec2 position, Vec2 direction) {
		super(position, direction, 1);
	}

	@Override
	public String toString() {
		// Change selon la direction demandée par l'énoncé
		if (direction.getX() == 1) return ">";
		if (direction.getX() == -1) return "<";
		if (direction.getY() == 1) return "v";
		if (direction.getY() == -1) return "^";
		return "-";
	}

}
