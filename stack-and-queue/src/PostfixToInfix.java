import java.util.Stack;

public class PostfixToInfix {
    public static String convert(String postfix) {
        Stack<String> stack = new Stack<>();

        for (char ch : postfix.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                stack.push(String.valueOf(ch));
            } else {
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                String expression = "(" + operand1 + ch + operand2 + ")";
                stack.push(expression);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String postfix = "ABC+*D/";
        System.out.println("Infix: " + convert(postfix));
    }
}
