import java.util.Random;

// Ennemi #1
public class Goblin extends GameObject implements Updatable, Damageable {

	private int healthPoint = 3;

	private Random rand = new Random(globalId);

	public Goblin(Vec2 position) {
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
		if (rand.nextInt(10) < 7)
		{
	        // TODO: Déplacer l'unité dans la direction POSSIBLE_DIR[rand.nextInt(4)].
			Vec2 dir = POSSIBLE_DIR[rand.nextInt(4)];
			Vec2 nextPos = new Vec2(
					this.position.getX() + dir.getX(),
					this.position.getY() + dir.getY()
			);

			if (world.isInBounds(nextPos) && world.get(nextPos).isEmpty()) {
				world.clear(this.position);
				this.position = nextPos;
				world.set(this.position, this);
			}
		}
		else
		{
		    // TODO: Tirer dans la direction POSSIBLE_DIR[rand.nextInt(4)].
			Vec2 dir = POSSIBLE_DIR[rand.nextInt(4)];
			Vec2 spawnPos = new Vec2(
					this.position.getX() + dir.getX(),
					this.position.getY() + dir.getY()
			);

			if (world.isInBounds(spawnPos) && world.get(spawnPos).isEmpty()) {
				Arrow arrow = new Arrow(spawnPos, dir);
				em.registerUpdatable(arrow, arrow);
			}
		}
		
	}

	@Override
	public String toString(){
		return "G";
	}

	@Override
	public void takeDamage(int amount){
		this.healthPoint = this.healthPoint - amount ;
	}

	@Override
	public Damageable asDamageable() {
		return this;
	}


}
