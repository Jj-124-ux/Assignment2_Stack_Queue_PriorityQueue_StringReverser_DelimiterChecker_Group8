public class PriorityQueue<T> {

    private T[] items;
    private int[] priorities;
    private int size;

    // Time Complexity: O(1)
    @SuppressWarnings("unchecked")
    public PriorityQueue(int arraySize) {
        if (arraySize < 1) {
            arraySize = 1;
        }
        items = (T[]) new Object[arraySize];
        priorities = new int[arraySize];
        size = 0;
    }

    // Time Complexity: O(n) (shifts lower-priority items to make room)
    public void insert(T newItem, int priorityValue) {
        if (size == items.length) {
            resize();
        }

        // Shift items with priority value <= the new one toward the end, so
        // the new item lands before equal-priority items (older ones leave first).
        int position = size;
        while (position > 0 && priorities[position - 1] <= priorityValue) {
            items[position] = items[position - 1];
            priorities[position] = priorities[position - 1];
            position--;
        }

        items[position] = newItem;
        priorities[position] = priorityValue;
        size++;
    }

    // Time Complexity: O(1)
    public T remove() {
        if (size == 0) {
            return null;
        }
        T item = items[size - 1];
        items[size - 1] = null;
        size--;
        return item;
    }

    // Time Complexity: O(1)
    public T peekFront() {
        if (size == 0) {
            return null;
        }
        return items[size - 1]; // highest priority
    }

    // Time Complexity: O(1)
    public T peekRear() {
        if (size == 0) {
            return null;
        }
        return items[0]; // lowest priority
    }

    // Time Complexity: O(n)
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        // print from front (highest priority) to rear (lowest priority)
        for (int i = size - 1; i >= 0; i--) {
            result.append(items[i]).append("(").append(priorities[i]).append(")");
            if (i > 0) {
                result.append(" ");
            }
        }

        return result.toString();
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