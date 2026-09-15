import java.util.ArrayList;
import java.util.List;

public class EventManager {

	private World world;

	private List<Updatable> updatables = new ArrayList<>();
	private List<GameObject> entities = new ArrayList<>();

	private List<GameObject> toAdd = new ArrayList<>();
	private List<GameObject> toRemove = new ArrayList<>();

	public EventManager(World w) {
		this.world = w;
	}

	public void register(GameObject obj) {
		toAdd.add(obj);
		world.set(obj.getPosition(), obj);
	}

	public void registerUpdatable(GameObject obj, Updatable u) {
		toAdd.add(obj);
		updatables.add(u);
		world.set(obj.getPosition(), obj);
	}

	public void remove(GameObject obj) {
		toRemove.add(obj);
	}

	public void processTurn() {
		for (GameObject obj : toAdd) {
			entities.add(obj);
		}
		toAdd.clear();

		for (Updatable u : updatables) {
			u.runIteration(world, this);
		}

		for (GameObject obj : entities) {
			if (obj.isDead()) {
				toRemove.add(obj);
			}
		}

		for (GameObject obj : toRemove) {
			entities.remove(obj);
			if (obj.asDamageable() != null) {
			}
			world.clear(obj.getPosition());
		}

		updatables.removeIf(u -> ((GameObject) u).isDead());
		toRemove.clear();
	}

	public List<GameObject> getEntities() {
		return entities;
	}
}