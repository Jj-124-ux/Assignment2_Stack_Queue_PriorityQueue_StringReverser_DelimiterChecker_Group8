public class StringReverser {

    public static String reverse(String input) {

        if (input == null) {
            return null;
        }

        Stack<Character> stack = new Stack<>(input.length());

        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        String result = "";

        while (stack.peek() != null) {
            result += stack.pop();
        }

        return result;
    }
}