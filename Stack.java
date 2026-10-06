public class Stack<T> {

    private T[] data;
    private int top; // index of the top element, -1 when empty

    // Time Complexity: O(1)
    @SuppressWarnings("unchecked")
    public Stack(int arraySize) {
        if (arraySize < 1) {
            arraySize = 1;
        }
        data = (T[]) new Object[arraySize];
        top = -1;
    }

    // Time Complexity: O(1) amortized (O(n) only when resizing)
    public void push(T newItem) {
        if (top == data.length - 1) {
            resize();
        }
        data[++top] = newItem;
    }

    // Time Complexity: O(1)
    public T pop() {
        if (top == -1) {
            return null;
        }
        T item = data[top];
        data[top--] = null;
        return item;
    }

    // Time Complexity: O(1)
    public T peek() {
        if (top == -1) {
            return null;
        }
        return data[top];
    }

    // Time Complexity: O(n)
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i <= top; i++) {
            result.append(data[i]);
            if (i < top) {
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
        for (int i = 0; i <= top; i++) {
            bigger[i] = data[i];
        }
        data = bigger;
    }
}