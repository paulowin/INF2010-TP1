
public class Hero extends GameObject implements Updatable, Damageable {

	private int healthPoint = 3;

	public Hero(Vec2 position) {
        super(position);
	}

	@Override
	public void runIteration(World world, EventManager em) {
		// Rien à faire ici, contrôlé à partir du main
	}


	@Override
	public String toString(){
		return Color.YELLOW + "H" + Color.RESET;
	}

	@Override
	public Damageable asDamageable() {
		return this;
	}

	@Override
	public void takeDamage(int amount){
		this.healthPoint = this.healthPoint - amount ;
	}

	@Override
	public boolean isDead() {
		return this.healthPoint <= 0;
	}

	public void move(Vec2 dir, EventManager em) {

		em.moveObject(this, dir);
	}

	public void shoot(Vec2 dir, World world, EventManager em) {
		Vec2 spawnPos = this.position.add(dir);

		if (world.isInBounds(spawnPos) && world.get(spawnPos).isEmpty()) {
			Fireball fireball = new Fireball(spawnPos, dir);
			em.registerUpdatable(fireball, fireball);
		}
	}


}
