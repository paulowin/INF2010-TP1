public abstract class Projectile extends GameObject implements Updatable {

	protected Vec2 direction;
	protected int damage;
	protected boolean destroyed = false;

	public Projectile(Vec2 position, Vec2 direction, int damage) {
		super(position);
		this.direction = direction;
		this.damage = damage;
	}

	@Override
	public void runIteration(World world, EventManager em) {

		boolean isOut = false;
		boolean hasCollided = false;

		// TODO: Détection de collision (si une case est occupé).
		Vec2 nextPos = new Vec2(
				this.position.getX() + this.direction.getX(),
				this.position.getY() + this.direction.getY()
		);

		if (!world.isInBounds(nextPos)) {
			isOut = true;
		} else if (!world.get(nextPos).isEmpty()) {
			hasCollided = true;
		}

		if (isOut)
		{
			// TODO: Détruire le projectile.
			this.destroyed = true;
			world.clear(this.position);
			return;
		}

		if (hasCollided) {
			// TODO: Trouver une façon d'appliquer du dommage à un objet, puis détruire le projectile.
			//       Astuce: implémenter une méthode de conversion "asDamageable".
			GameObject target = world.get(nextPos);
			Damageable damageableTarget = target.asDamageable();
			if (damageableTarget != null) {
				damageableTarget.takeDamage(this.damage);
			}
			this.destroyed = true;
			world.clear(this.position);
		} else {
			// TODO: Déplacer le projectile.
			world.clear(this.position);
			this.position = nextPos;
			world.set(this.position, this);
		}
	}

	public boolean isDestroyed() {
		return this.destroyed;
	}
}