public class EmptyCase extends GameObject {

    public EmptyCase(Vec2 position) {
        super(position);
    }

    @Override
    public String toString() {
        return " ";
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

}