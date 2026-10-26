public final class State {
    private final int jugA;
    private final int jugB;
    private final State parent;
    private final Action action;

    public State(int jugA, int jugB, State parent, Action action) {
        this.jugA = jugA;
        this.jugB = jugB;
        this.parent = parent;
        this.action = action;
    }

    public int getJugA()      { return jugA; }
    public int getJugB()      { return jugB; }
    public State getParent()  { return parent; }
    public Action getAction() { return action; }

    @Override
    public String toString() {
        return "(" + jugA + ", " + jugB + ")";
    }
}