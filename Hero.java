
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
		return "H";
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

	public void move(Vec2 dir, World world) {
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

	public void shoot(Vec2 dir, World world, EventManager em) {
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
