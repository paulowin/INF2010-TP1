import java.util.Random;

// Ennemi #2
public class GoblinKing extends GameObject implements Updatable, Damageable {

	private int healthPoint = 10;

	private Random rand = new Random(globalId);

	public GoblinKing(Vec2 position) {
		super(position);
	}

	@Override
	public void runIteration(World world, EventManager em) {
		final Vec2[] POSSIBLE_DIR = {
				new Vec2(0,-1),
				new Vec2(0,1),
				new Vec2(-1,0),
				new Vec2(1,0),
		};
		if (rand.nextInt(10) < 3) {
			Vec2 dir = POSSIBLE_DIR[rand.nextInt(4)];
			em.moveObject(this, dir);
		}
		else
		{
			Vec2 dir = POSSIBLE_DIR[rand.nextInt(4)];
			for (int i = 1; i <= 3; i++) {
				Vec2 spawnPos = new Vec2(
						this.position.getX() + dir.getX() * i,
						this.position.getY() + dir.getY() * i
				);

				if (world.isInBounds(spawnPos) && world.get(spawnPos).isEmpty()) {
					Arrow arrow = new Arrow(spawnPos, dir);
					em.registerUpdatable(arrow, arrow);
				}
			}
		}
	}

	@Override
	public String toString(){
		return Color.GREEN + "K" + Color.RESET;
	}

	@Override
	public Damageable asDamageable() {
		return this;
	}

	@Override
	public void takeDamage(int amount){
		this.healthPoint = this.healthPoint - amount;
	}

	@Override
	public boolean isDead() {
		return this.healthPoint <= 0;
	}
}