public abstract class Projectile extends GameObject implements Updatable {

	protected Vec2 direction;
	protected int damage;
	protected int speed;
	protected boolean destroyed = false;

	public Projectile(Vec2 position, Vec2 direction, int damage, int speed) {
		super(position);
		this.direction = direction;
		this.damage = damage;
		this.speed = speed;
	}

	@Override
	public void runIteration(World world, EventManager em) {

		for (int i = 0; i < this.speed; i++) {
			if (this.destroyed) break;

			boolean isOut = false;
			boolean hasCollided = false;


			// TODO: Détection de collision (si une case est occupé).
			Vec2 nextPos = this.position.add(this.direction);

			if (!world.isInBounds(nextPos)) {
				isOut = true;
			} else if (!world.get(nextPos).isEmpty()) {
				hasCollided = true;
			}

			if (isOut) {
				// TODO: Détruire le projectile.
				this.destroyed = true;
				world.clear(this.position);
				em.remove(this);
				return;
			}

			if (hasCollided) {
				// TODO: Trouver une façon d'appliquer du dommage à un objet, puis détruire le projectile.
				//       Astuce: implémenter une méthode de conversion "asDamageable".
				GameObject target = world.get(nextPos);
				target.asDamageable().takeDamage(this.damage);
				this.destroyed = true;
				world.clear(this.position);
				em.remove(this);
			} else {
				// TODO: Déplacer le projectile.
				world.clear(this.position);
				this.position = nextPos;
				world.set(this.position, this);
			}
		}
	}

	public boolean isDestroyed() {
		return this.destroyed;
	}
}