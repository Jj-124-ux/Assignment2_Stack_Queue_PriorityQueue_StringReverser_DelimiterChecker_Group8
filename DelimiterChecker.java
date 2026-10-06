public class DelimiterChecker {
    public static boolean check(String input) {
        Stack<Character> stack = new Stack<>(10);

        // Time Complexity: O(n)
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);

            if (current == '(' || current == '[' || current == '{') {
                stack.push(current);
            }

            else if (current == ')' || current == ']' || current == '}') {

                if (stack.peek() == null) {
                    return false;
                }

                char opening = stack.pop();
                if ((current == ')' && opening != '(')
                    || (current == ']' && opening != '[')
                    || (current == '}' && opening != '{')) {
                    return false;
                }
            }
        }

        return stack.peek() == null;
    }
}