import java.util.ArrayList;
import java.util.List;

public class EventManager {
	private World world;
	private List<GameObject> entities = new ArrayList<>();
	private List<Updatable> updatables = new ArrayList<>();

	// Listes tampons pour éviter les accès concurrents
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
		// 1. Appliquer les ajouts en attente
		entities.addAll(toAddEntities);
		updatables.addAll(toAddUpdatables);
		toAddEntities.clear();
		toAddUpdatables.clear();

		// 2. Mettre à jour toutes les entités actives
		for (Updatable u : updatables) {
			u.runIteration(world, this);
		}

		// 3. Détecter les entités mortes ou détruites
		for (GameObject obj : entities) {
			if (obj.isDead()) {
				toRemoveEntities.add(obj);
			}
		}

		// 4. Nettoyer la grille et les listes
		for (GameObject dead : toRemoveEntities) {
			world.clear(dead.getPosition());
			entities.remove(dead);
			if (dead instanceof Updatable) {
				updatables.remove((Updatable) dead);
			}
		}
		toRemoveEntities.clear();

		// 5. Réintégrer les éventuels projectiles spawnés pendant ce tour
		entities.addAll(toAddEntities);
		updatables.addAll(toAddUpdatables);
		toAddEntities.clear();
		toAddUpdatables.clear();
	}

	public List<GameObject> getEntities() {
		return entities;
	}
}