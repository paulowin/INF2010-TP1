
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
		
		if (isOut)
		{
			// TODO: Détruire le projectile.
			this.destroyed = true;
			return;
		}
			
		
		if (hasCollided) {		        
	        // TODO: Trouver une façon d'appliquer du dommage à un objet, puis détruire le projectile.
	        //       Astuce: implémenter une méthode de conversion "asDamageable".
			this.destroyed = true;
		} else {
            // TODO: Déplacer le projectile.
		}
	}
	public boolean isDestroyed() {
		return this.destroyed;
	}
}
