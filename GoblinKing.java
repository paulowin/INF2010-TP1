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
		if (rand.nextInt(10) < 3)
		{
			// TODO: Déplacer l'unité dans la direction POSSIBLE_DIR[rand.nextInt(4)].
		}
		else
		{
			// TODO: Tirer plusieurs projectiles dans la direction POSSIBLE_DIR[rand.nextInt(4)].
		}
	}

	@Override
	public String toString(){
		return "K";
	}

	@Override
	public Damageable asDamageable() {
		return this;
	}

	@Override
	public void takeDamage(int amount){
		this.healthPoint = this.healthPoint - amount ;
	}
}
