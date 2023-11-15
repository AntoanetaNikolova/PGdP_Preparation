public class FibonacciZahlen {
    public static void main(String[] args) {
        int n = 10; // Anzahl der Fibonacci-Zahlen, die generiert werden sollen

        System.out.println("Die ersten " + n + " Fibonacci-Zahlen:");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
