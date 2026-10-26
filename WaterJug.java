/** تعريف المشكلة: سعتا الوعاءين والهدف، وتوليد الحالات التالية. */
public class WaterJug {
    private final int capA;
    private final int capB;
    private final int target;

    public WaterJug(int capA, int capB, int target) {
        if (capA <= 0 || capB <= 0 || target < 0) {
            throw new IllegalArgumentException("Invalid capacities or target");
        }
        this.capA = capA;
        this.capB = capB;
        this.target = target;
    }

    public int getCapA() { return capA; }
    public int getCapB() { return capB; }

    public State start() {
        return new State(0, 0, null, Action.START);
    }

    public boolean isGoal(State s) {
        return s.getJugA() == target || s.getJugB() == target;
    }

    public State[] getNextStates(State cur) {
        int a = cur.getJugA();
        int b = cur.getJugB();

        int aToB = Math.min(a, capB - b);
        int bToA = Math.min(b, capA - a);

        return new State[] {
            new State(capA, b, cur, Action.FILL_A),
            new State(a, capB, cur, Action.FILL_B),
            new State(0, b, cur, Action.EMPTY_A),
            new State(a, 0, cur, Action.EMPTY_B),
            new State(a - aToB, b + aToB, cur, Action.POUR_A_TO_B),
            new State(a + bToA, b - bToA, cur, Action.POUR_B_TO_A)
        };
    }

    public String describe(Action action) {
        switch (action) {
            case START:       return "Start";
            case FILL_A:      return "Fill " + capA + "L";
            case FILL_B:      return "Fill " + capB + "L";
            case EMPTY_A:     return "Empty " + capA + "L";
            case EMPTY_B:     return "Empty " + capB + "L";
            case POUR_A_TO_B: return "Pour " + capA + "L to " + capB + "L";
            case POUR_B_TO_A: return "Pour " + capB + "L to " + capA + "L";
            default:          throw new IllegalStateException();
        }
    }
}