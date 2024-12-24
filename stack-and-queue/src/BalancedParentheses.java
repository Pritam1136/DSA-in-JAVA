import java.util.Stack;

public class BalancedParentheses {

    public static boolean isBalanced(String expression) {
        // Create a stack to store opening parentheses
        Stack<Character> stack = new Stack<>();

        // Iterate through the characters in the string
        for (char ch : expression.toCharArray()) {
            // Push opening brackets onto the stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // Check for closing brackets
            else if (ch == ')' || ch == '}' || ch == ']') {
                // If the stack is empty, it means no matching opening bracket
                if (stack.isEmpty()) {
                    return false;
                }
                // Pop from the stack and check if the brackets match
                char top = stack.pop();
                if (!isMatchingPair(top, ch)) {
                    return false;
                }
            }
        }

        // If the stack is empty, all brackets are balanced
        return stack.isEmpty();
    }

    // Helper method to check if two characters are matching parentheses
    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }

    public static void main(String[] args) {
        String expression = "{[()]}"; // Example input

        if (isBalanced(expression)) {
            System.out.println("The parentheses are balanced.");
        } else {
            System.out.println("The parentheses are not balanced.");
        }
    }
}
