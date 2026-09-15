import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class World implements Iterable<GameObject> {
	private final int width;
	private final int height;
	private final GameObject[][] grid;

	public World(int width, int height) {
		this.width = width;
		this.height = height;
		this.grid = new GameObject[height][width];

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				grid[y][x] = new EmptyCase(new Vec2(x, y));
			}
		}
	}

	public int getWidth() { return width; }
	public int getHeight() { return height; }

	public boolean isInBounds(Vec2 pos) {
		return pos.getX() >= 0 && pos.getX() < width && pos.getY() >= 0 && pos.getY() < height;
	}

	public GameObject get(Vec2 pos) {
		if (!isInBounds(pos)) return null;
		return grid[pos.getY()][pos.getX()];
	}


	public void set(Vec2 pos, GameObject obj) {
		if (!isInBounds(pos)) {
			throw new IllegalArgumentException("Position hors limites");
		}

		if (!grid[pos.getY()][pos.getX()].isEmpty()) {
			throw new IllegalStateException("La case est deja occupee");
		}

		grid[pos.getY()][pos.getX()] = obj;
		obj.setPosition(pos);
	}


	public void clear(Vec2 pos) {
		if (isInBounds(pos)) {
			grid[pos.getY()][pos.getX()] = new EmptyCase(pos);
		}
	}

	@Override
	public Iterator<GameObject> iterator() {
		List<GameObject> list = new ArrayList<>();
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				list.add(grid[y][x]);
			}
		}
		return list.iterator();
	}
}