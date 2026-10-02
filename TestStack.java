public class TestStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(2);
        stack.push(10);
        stack.push(20);
        stack.push(30);                      // full, so it resizes
        stack.display();                     // [10, 20, 30]
        System.out.println(stack.peek());    // 30
        System.out.println(stack.pop());     // 30
        stack.pop();
        stack.pop();
        System.out.println(stack.pop());
    }
}

