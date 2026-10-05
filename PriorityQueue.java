public class PriorityQueue<T> {

    private T[] items;
    private int[] priorities;
    private int size;

    @SuppressWarnings("unchecked")
    public PriorityQueue(int arraySize) {
        items = (T[]) new Object[arraySize];
        priorities = new int[arraySize];
        size = 0;
    }

    // Time Complexity: O(n)
    public void insert(T newItem, int priorityValue) {

        if (size == items.length) {
            resize();
        }

        int position = size;
        while (position > 0 &&
               priorities[position - 1] > priorityValue) {

            items[position] = items[position - 1];
            priorities[position] = priorities[position - 1];

            position--;
        }

        items[position] = newItem;
        priorities[position] = priorityValue;
        size++;
    }

    // Time Complexity: O(n) because remaining items are shifted.
    public T remove() {
        if (size == 0) {
            return null;
        }

        T item = items[0];

        for (int i = 0; i < size - 1; i++) {
            items[i] = items[i + 1];
            priorities[i] = priorities[i + 1];
        }

        items[size - 1] = null;
        size--;

        return item;
    }

    // Time Complexity: O(1)
    public T peekFront() {
        if (size == 0) {
            return null;
        }
        return items[0];
    }

    // Time Complexity: O(1)
    public T peekRear() {
        if (size == 0) {
            return null;
        }

        return items[size - 1];
    }

    // Time Complexity: O(n)
    @Override
    public String toString() {
        String result = "";

        for (int i = 0; i < size; i++) {
            result += items[i] + "(" + priorities[i] + ")";

            if (i < size - 1) {
                result += " ";
            }
        }

        return result;
    }

    // Time Complexity: O(n)
    public void display() {
        System.out.println(toString());
    }

    // Time Complexity: O(n)
    @SuppressWarnings("unchecked")
    private void resize() {
        T[] newItems = (T[]) new Object[items.length * 2];
        int[] newPriorities = new int[priorities.length * 2];

        for (int i = 0; i < size; i++) {
            newItems[i] = items[i];
            newPriorities[i] = priorities[i];
        }

        items = newItems;
        priorities = newPriorities;
    }
}
    
