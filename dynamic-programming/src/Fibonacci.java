public class Fibonacci {
    public static void main(String[] args) {
        int n = 10; // Example: find the 10th Fibonacci number
        System.out.println("Fibonacci of " + n + " is: " + fibonacci(n));
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        int a = 0; // Fibonacci(0)
        int b = 1; // Fibonacci(1)
        int fib = 0;

        for (int i = 2; i <= n; i++) {
            fib = a + b; // Calculate the next Fibonacci number
            a = b;       // Move forward in the sequence
            b = fib;     // Update to the latest Fibonacci number
        }

        return fib; // Return the nth Fibonacci number
    }
}
