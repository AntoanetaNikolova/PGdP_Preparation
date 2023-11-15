public class W3P2 {
    public class Array {

        public static int[][] minsAndMaxs(int[][] a) {
            int[][] out = new int[a.length][2];

            for (int i = 0; i < a.length; i++) {
                // 2D Arrays are arrays of arrays
                // so a[i] is an array
                out[i] = minAndMax(a[i]);
            }

            return out;
        }

        public static int[] minAndMax(int[] a) {
            if (a.length == 0) {
                return null;
            }

            int min = a[0];
            int max = a[0];
            for (int i = 1; i < a.length; i++) {
                if (a[i] < min) {
                    min = a[i];
                }
                if (a[i] > max) {
                    max = a[i];
                }
            }
            return new int[]{min, max};
        }

        public static int[][] transpose(int[][] a) {
            if (a.length == 0 || a[0].length == 0) {
                return null;
            }

            int[][] transposed = new int[a[0].length][a.length];
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[i].length; j++) {
                    transposed[j][i] = a[i][j];
                }
            }

            return transposed;
        }

        public static int[] linearize(int[][] a) {
            int linearizedlength = 0;

            for (int i = 0; i < a.length; i++) {
                linearizedlength += a[i].length;
            }

            int[] linearized = new int[linearizedlength];
            int linearizedIndex = 0;

            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[i].length; j++) {
                    linearized[linearizedIndex++] = a[i][j];
                }
            }

            return linearized;
        }

        public static boolean crossword(char[][] letterGrid, char[] word) {
            if (word.length == 0) {
                return true;
            }

            if (letterGrid.length == 0 || letterGrid[0].length == 0) {
                return false;
            }

            for (int row = 0; row < letterGrid.length; row++) {
                for (int column = 0; column < letterGrid[row].length; column++) {
                    if (hasWordRightwardsAt(letterGrid, word, row, column)
                            || hasWordDownwardsAt(letterGrid, word, row, column)
                            || hasWordDiagonallyAt(letterGrid, word, row, column)) {
                        return true;
                    }
                }
            }
            return false;
        }

        /**
         * Checks whether the word can be found in the letter grid starting at the given position
         * and going rightwards
         */
        public static boolean hasWordRightwardsAt(char[][] letterGrid, char[] word, int row, int column) {
            if (column + word.length > letterGrid[row].length) { // Word cannot fit
                return false;
            }
            for (int i = 0; i < word.length; i++) {
                if (letterGrid[row][column + i] != word[i]) {
                    return false;
                }
            }
            return true;
        }

        /**
         * Checks whether the word can be found in the letter grid starting at the given position
         * and going downwards
         */
        public static boolean hasWordDownwardsAt(char[][] letterGrid, char[] word, int row, int column) {
            if (row + word.length > letterGrid.length) { // Word cannot fit
                return false;
            }
            for (int i = 0; i < word.length; i++) {
                if (letterGrid[row + i][column] != word[i]) {
                    return false;
                }
            }
            return true;
        }

        /**
         * Checks whether the word can be found in the letter grid starting at the given position
         * and going diagonally rightwards and downwards
         */
        public static boolean hasWordDiagonallyAt(char[][] letterGrid, char[] word, int row, int column) {
            if (row + word.length > letterGrid.length || column + word.length > letterGrid[row].length) { // Word cannot fit
                return false;
            }
            for (int i = 0; i < word.length; i++) {
                if (letterGrid[row + i][column + i] != word[i]) {
                    return false;
                }
            }
            return true;
        }

    }
}
