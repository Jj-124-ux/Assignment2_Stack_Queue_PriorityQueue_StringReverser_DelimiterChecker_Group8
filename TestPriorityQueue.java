public class TestPriorityQueue {

    public static void main(String[] args) {

        PriorityQueue<String> pq = new PriorityQueue<>(3);

        // Insert items
        pq.insert("Assignment1", 3);
        pq.insert("Assignment3", 1);
        pq.insert("Assignment2", 2);

        System.out.println("Priority Queue: " + pq);

        // Test peekFront()
        System.out.println("Peek Front: " + pq.peekFront());

        // Test peekRear()
        System.out.println("Peek Rear: " + pq.peekRear());

        // Test remove()
        System.out.println("Remove: " + pq.remove());
        System.out.println("After remove: " + pq);

        System.out.println("Remove: " + pq.remove());
        System.out.println("After remove: " + pq);

        System.out.println("Remove: " + pq.remove());
        System.out.println("After remove: " + pq);

        // Test empty queue
        System.out.println("Remove empty: " + pq.remove());
        System.out.println("Peek Front empty: " + pq.peekFront());
        System.out.println("Peek Rear empty: " + pq.peekRear());
    }
}
