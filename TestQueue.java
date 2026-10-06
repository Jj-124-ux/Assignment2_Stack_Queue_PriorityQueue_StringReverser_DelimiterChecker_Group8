public class TestQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>(3);
        System.out.println(q.remove());
        System.out.println(q.peekFront());

        q.insert(1);
        q.insert(2);
        q.insert(3);
        q.display();

        System.out.println(q.remove());
        q.insert(4);
        q.insert(5);
        q.display();
        System.out.println(q.peekFront());
        System.out.println(q.peekRear());
    }
}