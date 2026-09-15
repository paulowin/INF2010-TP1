public class EmptyCase extends GameObject {

    public EmptyCase(Vec2 position) {
        super(position)
    }

    @Override
    public abstract String toString() {
        return " ";
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

}