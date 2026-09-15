import java.util.ArrayList;
import java.util.List;

public class EventManager {
	private World world;
	private List<GameObject> entities = new ArrayList<>();
	private List<Updatable> updatables = new ArrayList<>();

	private List<GameObject> toAddEntities = new ArrayList<>();
	private List<Updatable> toAddUpdatables = new ArrayList<>();
	private List<GameObject> toRemoveEntities = new ArrayList<>();

	public EventManager(World world) {
		this.world = world;
	}

	public void register(GameObject obj) {
		toAddEntities.add(obj);
		world.set(obj.getPosition(), obj);
	}

	public void registerUpdatable(GameObject obj, Updatable updatable) {
		toAddEntities.add(obj);
		toAddUpdatables.add(updatable);
		world.set(obj.getPosition(), obj);
	}

	public void remove(GameObject obj) {
		toRemoveEntities.add(obj);
	}

	public void processTurn() {
		entities.addAll(toAddEntities);
		updatables.addAll(toAddUpdatables);
		toAddEntities.clear();
		toAddUpdatables.clear();

		for (Updatable u : updatables) {
			u.runIteration(world, this);
		}

		for (GameObject obj : entities) {
			if (obj.isDead()) {
				toRemoveEntities.add(obj);
			}
		}

		for (GameObject dead : toRemoveEntities) {
			world.clear(dead.getPosition());
			entities.remove(dead);
			updatables.remove(dead);
		}
		toRemoveEntities.clear();

		entities.addAll(toAddEntities);
		updatables.addAll(toAddUpdatables);
		toAddEntities.clear();
		toAddUpdatables.clear();
	}

	public List<GameObject> getEntities() {
		return entities;
	}
}