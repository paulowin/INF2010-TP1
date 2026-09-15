
// Projectile #1
public class Fireball extends Projectile {

	public Fireball(Vec2 position, Vec2 direction) {
		super(position, direction, 1);
	}

	@Override
	public String toString() {
		return "*";
	}
	
}
