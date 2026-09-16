public class BreakableWall extends GameObject implements Damageable {

	private boolean broken = false;

	public BreakableWall(Vec2 position) {
		super(position);
	}

	@Override
	public String toString() {
		return Color.BLUE + "▒" + Color.RESET;
	}

	@Override
	public void takeDamage(int amount) {
		this.broken = true;
	}

	@Override
	public boolean isDead() {
		return this.broken;
	}

	@Override
	public Damageable asDamageable() {
		return this;
	}
}