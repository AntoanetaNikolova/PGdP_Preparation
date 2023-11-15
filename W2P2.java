public class W2P2 {
    public class ControlStructuresI {
        public static void main(String[] args) {
            System.out.println(reverseNumber(1_000));
        }

        public static void printCollatz(int n) {
            if(n < 1) {
                System.out.println("Eingabe muss größer als 0 sein!");
                return;
            }

            int count = 1;
            while (n > 1) {
                System.out.print(n + " ");
                if(n % 2 == 0) {
                    n = n / 2;
                } else {
                    n = 3*n + 1;
                }
                count++;
            }

            System.out.println("1");
            System.out.println("Länge: " + count);
        }

        public static void printPowersOfTwoUpTo(int n) {
            if(n < 1) {
                System.out.println("Eingabe muss größer als 0 sein!");
                return;
            }

            int powerOfTwo = 1;
            while(powerOfTwo <= n / 2) {
                System.out.print(powerOfTwo + " ");
                powerOfTwo = powerOfTwo * 2;
            }
            System.out.println(powerOfTwo);
        }

        public static void printTriangle(int sideLength) {
            if(sideLength < 1) {
                System.out.println("Eingabe muss größer als 0 sein!");
                return;
            }

            while(sideLength > 0) {
                int positionInLine = 0;
                while(positionInLine < sideLength) {
                    System.out.print('*');
                    positionInLine = positionInLine + 1;
                }
                sideLength = sideLength - 1;
                System.out.println();
            }
        }

        public static int calculateNumberOfDigits(int n) {
            int numberOfDigits = 0;
            while(n > 0) {
                n = n / 10;
                numberOfDigits = numberOfDigits + 1;
            }
            return numberOfDigits;
        }

        public static int reverseNumber(int n) {
            int reversedNumber = 0;
            while(n > 0) {
                reversedNumber = reversedNumber * 10;
                reversedNumber = reversedNumber + n % 10;
                n = n / 10;
            }
            return reversedNumber;
        }

        public static boolean isPalindrome(int n) {
            return n == reverseNumber(n);
        }
    }
}
