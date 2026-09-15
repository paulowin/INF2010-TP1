import java.io.IOException;

public class Main {
	
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
        System.out.flush();
	}
	
	public static void renderWorld(World w) {
		// TODO: Implémentation du dessin
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
    	
    	World w = new World();
    	EventManager em = new EventManager(w);
    	
    	Hero h = new Hero();
    	// TODO: Ajouter l'objet quelque part

        // TODO: Créer et ajouter les autres objets
    	
    	while (isRunning)
    	{
    	    // TODO: Boucle de mise à jours
    	    // TODO: Supprimer les objets non vivant (qui ont subis suffisamment de dégat pour être retirés)
    	    // TODO: Ajouter/retirer les éléments qui ont fait des accès concurrent
    		
    		clearScreen();
    		renderWorld(w);

    		int key;
    		do {
    			System.out.print("Input an action: ");
        		key = getInput();
        		// TODO: À revoir et compléter avec les autres entrées
    			if (key == 'q')
    				isRunning = false;
    		} while ("wasdfq".indexOf(key) == -1);
    		
    	}
    	
    	// TODO: Imprimer tous les éléments du jeu encore actif.
    	//       Utiliser directement des print du style "System.out.println(objet)"
    }

}

