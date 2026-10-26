/** طابور دائري بسعة ثابتة. */
public class StateQueue {
    private final State[] data;
    private int front = 0;
    private int size = 0;

    public StateQueue(int capacity) {
        data = new State[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(State s) {
        if (size == data.length) {
            throw new IllegalStateException("Queue is full");
        }
        data[(front + size) % data.length] = s;
        size++;
    }

    public State dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        State s = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return s;
    }
}