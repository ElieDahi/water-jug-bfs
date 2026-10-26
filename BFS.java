public class BFS {
    private final WaterJug game;

    public BFS(WaterJug game) {
        this.game = game;
    }

    public void search() {
        int rows = game.getCapA() + 1;
        int cols = game.getCapB() + 1;

        Statequeue queue = new Statequeue(rows * cols);
        boolean[][] visited = new boolean[rows][cols];

        State start = game.start();
        queue.enqueue(start);
        visited[start.getJugA()][start.getJugB()] = true;

        while (!queue.isEmpty()) {
            State current = queue.dequeue();
            System.out.println("Visiting: " + current);

            if (game.isGoal(current)) {
                System.out.println("Goal Found!");
                printSolution(current);
                return;
            }

            for (State s : game.getNextStates(current)) {
                if (!visited[s.getJugA()][s.getJugB()]) {
                    visited[s.getJugA()][s.getJugB()] = true;
                    queue.enqueue(s);
                }
            }
        }
        System.out.println("No Solution!");
    }

    private void printSolution(State goal) {
        int steps = 0;
        for (State t = goal; t != null; t = t.getParent()) {
            steps++;
        }

        State[] path = new State[steps];
        State t = goal;
        for (int i = steps - 1; i >= 0; i--) {
            path[i] = t;
            t = t.getParent();
        }

        System.out.println("\nSolution Path:");
        for (State s : path) {
            System.out.println(game.describe(s.getAction()) + ": " + s);
        }
        System.out.println("Moves: " + (steps - 1));
    }
}