public abstract class GameObject {
    private static int nextId = 0;

    private final int globalId;
    protected Vec2 position;

    public GameObject(Vec2 position) {
        this.globalId = nextId++;
        this.position = position;
    }

    public int getId() { return id; }
    public Vec2 getPosition() { return position; }
    public void setPosition(Vec2 pos) { this.position = pos; }

    @Override
    public abstract String toString();