public class TestAll {
    public static void main(String[] args) {
        // Stack
        Stack<Integer> s = new Stack<>(1);
        System.out.println("Empty pop: " + s.pop());
        for (int i = 0; i < 4; i++) s.push(i);
        s.display();                       // [0, 1, 2, 3]
        System.out.println(s.pop());       // 3

        // Queue
        Queue<Integer> q = new Queue<>(2);
        System.out.println("Empty remove: " + q.remove());
        for (int i = 0; i < 5; i++) q.insert(i);
        q.remove();
        q.insert(9);
        q.display();                       // [1, 2, 3, 4, 9]
        System.out.println(q.peekFront() + " " + q.peekRear()); // 1 9

        // PriorityQueue
        PriorityQueue<String> p = new PriorityQueue<>(2);
        p.insert("c", 3);
        p.insert("a1", 1);
        p.insert("b", 2);
        p.insert("a2", 1);
        p.display();                       // a1(1) a2(1) b(2) c(3)
        System.out.println(p.remove() + " " + p.remove()); // a1 a2
        System.out.println(p.peekFront() + " " + p.peekRear()); // b c
    }
}