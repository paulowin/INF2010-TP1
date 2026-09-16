public abstract class GameObject {
    private static int nextId = 0;

    protected final int globalId;
    protected Vec2 position;

    private static final Damageable NULL_DAMAGEABLE = new NullDamageable();

    private static class NullDamageable implements Damageable {
        @Override
        public void takeDamage(int amount) {}

        @Override
        public boolean isDead() {
            return false;
        }
    }

    public GameObject(Vec2 position) {
        this.globalId = nextId++;
        this.position = position;
    }

    public int getId() {
        return globalId;
    }

    public Vec2 getPosition() {
        return position;
    }

    public void setPosition(Vec2 pos) {
        this.position = pos;
    }

    public boolean isEmpty() {
        return false;
    }

    public Damageable asDamageable() {
        return NULL_DAMAGEABLE;
    }

    public boolean isDead() {
        return false;
    }

    @Override
    public abstract String toString();
}