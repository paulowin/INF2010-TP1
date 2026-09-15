
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





}
