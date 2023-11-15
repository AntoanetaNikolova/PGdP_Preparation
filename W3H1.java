import java.util.Arrays;

public class W3H1 {
    public class ArrayFunctions {

        protected ArrayFunctions() {
            throw new IllegalStateException("Don't create objects of type 'ArrayFunctions'!");
        }

        public static void main(String[] args) {
            int[] array = {1, 2, 3};
            int amount = 1;
            rotate(array, amount);
            System.out.println(Arrays.toString(array));
        }

        /** Berechnet für das übergebene Array die Summe der Quadrate der Einträge.
         *  Gibt dabei einen Fehler aus und -1 zurück, wenn ein Overflow entsteht.
         *
         * @param array Ein beliebiges Integer-Array.
         * @return Die Länge, wenn diese in einen 'long' passt, -1 sonst.
         */
        public static long sumOfSquares(int[] array) {
            long sumOfSquares = 0;
            for(int i = 0; i < array.length; i++) {
                long square = (long) array[i] * (long) array[i];
                if(Long.MAX_VALUE - sumOfSquares < square) {
                    System.out.println("Overflow!");
                    return -1;
                }

                sumOfSquares += square;
            }

            return sumOfSquares;
        }


        /** Methode, die zwei Arrays zu einem verbindet, indem sie abwechselnd Einträge des ersten und des zweiten Input-
         *  Arrays verwendet.
         *
         * @param a Ein beliebiges Integer-Array.
         * @param b Ein beliebiges Integer-Array.
         * @return 'a' und 'b' zusammengezipped.
         */
        public static int[] zip(int[] a, int[] b){
            int[] zippedArray = new int[a.length + b.length];
            int minLength = Math.min(a.length, b.length);

            for(int i = 0; i < minLength; i++) {
                zippedArray[2*i] = a[i];
                zippedArray[2*i + 1] = b[i];
            }

            if(a.length < b.length) {
                for(int i = minLength; i < b.length; i++) {
                    zippedArray[minLength + i] = b[i];
                }
            } else {
                for(int i = minLength; i < a.length; i++) {
                    zippedArray[minLength + i] = a[i];
                }
            }

            return zippedArray;
        }

        /** Methode, die eine beliebige Zahl an Arrays (dargestellt als Array von Arrays) zu einem einzigen Array verbindet,
         *  indem sie abwechselnd von jedem Array einen Eintrag nimmt, bis alle aufgebraucht sind.
         *
         * @param arrays Array von Integer-Arrays
         * @return Die Arrays in 'arrays' zusammengezipped
         */
        public static int[] zipMany(int[][] arrays){
            int maxLength = 0;
            int sumOfLengths = 0;
            for(int i = 0; i < arrays.length; i++) {
                sumOfLengths += arrays[i].length;
                if(arrays[i].length > maxLength) {
                    maxLength = arrays[i].length;
                }
            }

            int[] zippedArray = new int[sumOfLengths];
            int nextPosition = 0;
            for(int j = 0; j < maxLength; j++) {
                for(int i = 0; i < arrays.length; i++) {
                    if(j < arrays[i].length) {
                        zippedArray[nextPosition] = arrays[i][j];
                        nextPosition++;
                    }
                }
            }

            return zippedArray;
        }

        /** Behält aus dem übergebenen Array nur die Einträge, die innerhalb der übergebenen Grenzen liegen.
         *  Gibt das Ergebnis als neues Array zurück.
         *
         * @param array Ein beliebiges Integer-Array
         * @param min Ein beliebiger Integer
         * @param max Ein beliebiger Integer
         * @return Das gefilterte Array
         */
        public static int[] filter(int[] array,int min,int max){
            int firstUnusedPosition = 0;
            int[] out = new int[array.length];
            for (int j = 0; j < array.length; j++){
                if(array[j] >= min && array[j] <= max) {
                    out[firstUnusedPosition] = array[j];
                    firstUnusedPosition++;
                }
            }

            return Arrays.copyOf(out,firstUnusedPosition);
        }

        /** Rotiert das übergebene Array um die übergebene Anzahl an Schritten nach rechts.
         *  Das Array wird In-Place rotiert. Es gibt keine Rückgabe.
         *
         * @param array Ein beliebiges Integer-Array
         * @param amount Ein beliebiger Integer
         */
        public static void rotate(int[] array, int amount) {
            int length = array.length;

            if(length == 0) {
                return;
            }

            // Get rotation amount into range [0, array.length - 1]
            amount = amount % length;
            if(amount < 0) {
                amount += length;
            }

            // Rotate into new array
            int[] rotated = new int[length];
            for(int i = 0; i < length; i++) {
                rotated[(i + amount) % length] = array[i];
            }

            // Copy from this new array back into old one
            for(int i = 0; i < length; i++) {
                array[i] = rotated[i];
            }
        }

        /** Zählt die Anzahl an Vorkommen jeder Zahl im übergebenen Array, die in diesem mindestens einmal vorkommt.
         *  Die Rückgabe erfolgt über ein 2D-Array, bei dem jedes innere Array aus zwei Einträgen besteht: Einer Zahl,
         *  die im übergebenen Array vorkommt sowie der Anzahl an Vorkommen dieser.
         *  Für jede im übergebenen Array vorkommenden Zahl gibt es ein solches inneres Array.
         *  Diese tauchen im Rückgabewert in der gleichen Reihenfolge auf, in der die jeweils ersten Vorkommen der Zahlen
         *  im übergebenen Array auftauchen.
         *
         * @param array Ein beliebiges Integer-Array
         * @return Das Array mit den Vielfachheiten der einzelnen Zahlen, wiederum als Integer-Arrays mit zwei Einträgen dargestellt.
         */
        public static int[][] quantities(int[] array) {
            int[][] quantitiesArray = new int[array.length][2];
            int nextPosition = 0;

            for(int i = 0; i < array.length; i++) {
                boolean isInQuantitiesArray = false;
                for(int j = 0; j < nextPosition; j++) {
                    if(quantitiesArray[j][0] == array[i]) {
                        quantitiesArray[j][1]++;
                        isInQuantitiesArray = true;
                        break;
                    }
                }

                if(!isInQuantitiesArray) {
                    quantitiesArray[nextPosition] = new int[] { array[i], 1 };
                    nextPosition++;
                }
            }

            // Cut of unnecessary parts
            int[][] reducedQuantitiesArray = new int[nextPosition][2];
            for(int i = 0; i < nextPosition; i++) {
                reducedQuantitiesArray[i] = quantitiesArray[i];
            }

            return reducedQuantitiesArray;
        }
    }
}
