public class Tuerme_von_Hanoi {
    public static void main(String[] args) {
        int numberOfDiscs = 3; // Anzahl der Scheiben
        char sourcePeg = 'A';
        char auxiliaryPeg = 'B';
        char destinationPeg = 'C';

        solveHanoi(numberOfDiscs, sourcePeg, auxiliaryPeg, destinationPeg);
    }

    public static void solveHanoi(int n, char source, char auxiliary, char destination) {
        if (n == 1) {
            System.out.println("Bewege Scheibe 1 von " + source + " nach " + destination);
        } else {
            solveHanoi(n - 1, source, destination, auxiliary);
            System.out.println("Bewege Scheibe " + n + " von " + source + " nach " + destination);
            solveHanoi(n - 1, auxiliary, source, destination);
        }
    }
}
