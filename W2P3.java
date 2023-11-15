public class W2P3 {
    public class ControlStructuresII {
        public static void main(String[] args) {
            printPrimesUpTo(100);

        }

        public static int threeAndSeven(int n) {
            if(n < 0) {
                System.out.println("Eingabe muss größer oder gleich 0 sein!");
                return -1;
            }

            int sum = 0;
            for(int i = 0; i <= n; i++) {
                if(i % 3 == 0 || i % 7 == 0) {
                    sum += i;
                }
            }
            return sum;
        }

        /**
         * Optionale Lösung für diese Aufgabe ohne Schleifen, die so nicht erwartet wird. Die obere Lösung ist komplett ausreichend!
         * Sie hat aber den Vorteil, dass sie egal wie groß der Parameter n ist, immer gleich schnell und schneller als die obere Lösung sein wird.
         */
        public static int threeAndSevenPerformant(int n) {
            if(n < 0) {
                System.out.println("Eingabe muss größer oder gleich 0 sein!");
                return -1;
            }

            // Anzahl der Vielfachen in n. Z.B.:
            // n=2 => numMultipleOfThrees=0
            // n=7 => numMultipleOfThrees=2, da 7/3=2
            int numMultipleOfThrees = n / 3;
            int numMultipleOfSevens = n / 7;
            int numMultipleOfTwentyOnes = n / 21;

            // Berechnung der Summe aller Vielfachen mit kleinem Gauß.
            // Z.B. numMultipleOfThrees=4 => 3,6,9,12 sind die Vielfachen
            // 3+6+9+12 = 3*(1+2+3+4) = 3*(4*5/2)
            int sumThrees = numMultipleOfThrees * (numMultipleOfThrees + 1) / 2 * 3;
            int sumSevens = numMultipleOfSevens * (numMultipleOfSevens + 1) / 2 * 7;
            int sumTwentyOnes = numMultipleOfTwentyOnes * (numMultipleOfTwentyOnes + 1) / 2 * 21;

            // Summieren der 3er und 7er und da alle Vielfachen von 21 sonst doppelt gezählt werden (teilbar durch drei UND sieben), werden sie einmal abgezogen
            int sum = sumThrees + sumSevens - sumTwentyOnes;

            return sum;
        }

        public static void printAsciiCodesFor(char start, int count) {
            int startAsInt = (int) start;
            for(int i = start; i < start + count; i++) {
                System.out.println("Der ASCII-Code von '" + (char) i + "' ist " + i + ".");
            }
        }

        public static void printMultiplicationTable(int n) {
            System.out.print("*\t|\t");
            for(int i = 1; i <= n; i++) {
                System.out.print(i + "\t");
            }
            System.out.println();

            for(int i = 1; i <= n+2; i++) {
                System.out.print("----");
            }
            System.out.println();

            for(int i = 1; i <= n; i++) {
                System.out.print(i + "\t|\t");
                for(int j = 1; j <= n; j++) {
                    System.out.print(i*j + "\t");
                }
                System.out.println();
            }
        }

        public static void printPrimesUpTo(int n) {
            for(int i = 2; i <= n; i++) {
                if(isPrime(i)) {
                    System.out.print(i + " ");
                }
            }
        }

        public static boolean isPrime(int n) {
            if (n < 2) {
                return false;
            }
            for (int i = 2; i*i <= n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
