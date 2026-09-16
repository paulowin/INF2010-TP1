import java.io.IOException;

public class Main {

	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public static void renderWorld(World w) {
		// TODO: Implémentation du dessin
		for (int y = 0; y < w.getHeight(); y++) {
			for (int x = 0; x < w.getWidth(); x++) {
				System.out.print("[" + w.get(new Vec2(x, y)).toString() + "]");
			}
			System.out.println();
		}
	}

	public static int getInput() {
		try {
			int key = System.in.read();
			System.in.skip(System.in.available());
			return key;
		} catch(IOException e) {
			return 0;
		}
	}

	static public boolean isRunning = true;

	public static void main(String[] args) {

		World w = new World(20, 10);
		EventManager em = new EventManager(w);

		Hero h = new Hero(new Vec2(2, 2));
		// TODO: Ajouter l'objet quelque part
		em.registerUpdatable(h, h);

		// TODO: Créer et ajouter les autres objets
		Goblin g = new Goblin(new Vec2(10, 5));
		em.registerUpdatable(g, g);

		GoblinKing gk = new GoblinKing(new Vec2(15, 7));
		em.registerUpdatable(gk, gk);

		BreakableWall bw = new BreakableWall(new Vec2(5, 5));
		em.register(bw);

		SolidWall sw = new SolidWall(new Vec2(5, 6));
		em.register(sw);

		while (isRunning)
		{
			// TODO: Boucle de mise à jours
			// TODO: Supprimer les objets non vivant (qui ont subis suffisamment de dégat pour être retirés)
			// TODO: Ajouter/retirer les éléments qui ont fait des accès concurrent
			em.processTurn();

			if (h.isDead()) {
				isRunning = false;
			}

			clearScreen();
			renderWorld(w);

			int key;
			do {
				System.out.print("Input an action: ");
				key = getInput();
				// TODO: À revoir et compléter avec les autres entrées
				if (key == 'w') {
					h.move(new Vec2(0, -1), em);
				} else if (key == 's') {
					h.move(new Vec2(0, 1), em);
				} else if (key == 'a') {
					h.move(new Vec2(-1, 0), em);
				} else if (key == 'd') {
					h.move(new Vec2(1, 0), em);
				} else if (key == 'f') {
					System.out.print("\nDirection du tir (w/a/s/d) : ");
					int dirKey = getInput();
					Vec2 shootDir = null;

					if (dirKey == 'w') shootDir = new Vec2(0, -1);
					else if (dirKey == 's') shootDir = new Vec2(0, 1);
					else if (dirKey == 'a') shootDir = new Vec2(-1, 0);
					else if (dirKey == 'd') shootDir = new Vec2(1, 0);

					if (shootDir != null) {
						h.shoot(shootDir, w, em);
					} else {
						System.out.println("Tir annulé : touche invalide.");
					}
				} else if (key == 'q') {
					isRunning = false;
				}
			} while ("wasdfq".indexOf(key) == -1);

		}

		// TODO: Imprimer tous les éléments du jeu encore actif.
		//       Utiliser directement des print du style "System.out.println(objet)"
		System.out.println("\n--- Objets encore actifs dans la partie ---");
		for (GameObject obj : em.getEntities()) {
			System.out.println(obj);
		}
	}

}