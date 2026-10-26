# Water Jug Problem – BFS

Solves the classic water jug problem (7L and 5L jugs, target = 2L)
using Breadth-First Search, with a custom circular queue.

## Structure
- `App.java` – entry point
- `BFS.java` – search algorithm and path printing
- `WaterJug.java` – problem definition and state transitions
- `State.java` – immutable state
- `StateQueue.java` – circular queue
- `Action.java` – available actions

## Run
```bash
javac *.java
java App
```

## Output
```
Start: (0, 0)
Fill 7L: (7, 0)
Pour 7L to 5L: (2, 5)
Moves: 2
```
