public class InfixToPrefix {
    public static String convert(String infix) {
        String reversedInfix = new StringBuilder(infix).reverse().toString();
        StringBuilder modified = new StringBuilder();

        for (char ch : reversedInfix.toCharArray()) {
            if (ch == '(') {
                modified.append(')');
            } else if (ch == ')') {
                modified.append('(');
            } else {
                modified.append(ch);
            }
        }
        String postfix = InfixToPostfix.convert(modified.toString());
        return new StringBuilder(postfix).reverse().toString();
    }

    public static void main(String[] args) {
        String infix = "A*(B+C)/D";
        System.out.println("Prefix: " + convert(infix));
    }
}
