
public class Queue<T> {

    private T[] data;
    private int front;
    private int rear;
    private int size;

    // Time Complexity: O(1)
    @SuppressWarnings("unchecked")
    public Queue(int arraySize) {
        if (arraySize < 1) {
            arraySize = 1;
        }
        data = (T[]) new Object[arraySize];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Time Complexity: O(1) amortized (O(n) only when resizing)
    public void insert(T newItem) {
        if (size == data.length) {
            resize();
        }
        rear = (rear + 1) % data.length;
        data[rear] = newItem;
        size++;
    }

    // Time Complexity: O(1)
    public T remove() {
        if (size == 0) {
            return null;
        }
        T item = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return item;
    }

    // Time Complexity: O(1)
    public T peekFront() {
        if (size == 0) {
            return null;
        }
        return data[front];
    }

    // Time Complexity: O(1)
    public T peekRear() {
        if (size == 0) {
            return null;
        }
        return data[rear];
    }

    // Time Complexity: O(n)
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            result.append(data[(front + i) % data.length]);
            if (i < size - 1) {
                result.append(", ");
            }
        }
        return result.append("]").toString();
    }

    // Time Complexity: O(n)
    public void display() {
        System.out.println(toString());
    }

    // Time Complexity: O(n)
    @SuppressWarnings("unchecked")
    private void resize() {
        T[] bigger = (T[]) new Object[data.length * 2];
        for (int i = 0; i < size; i++) {
            bigger[i] = data[(front + i) % data.length];
        }
        data = bigger;
        front = 0;
        rear = size - 1;
    }
}
 