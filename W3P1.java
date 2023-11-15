public class W3P1 {
    public class Array {

        //ToDo: equvalent to Array.toString() "[one, two, three]"
        public static void print(int[] a) {
            System.out.print("{");

            if (a.length > 0) {
                System.out.print(a[0]);
                for (int i = 1; i < a.length; i++) {
                    System.out.print(", " + a[i]);
                }
            }

            System.out.print("}");
        }

        //ToDo:
        public static void minAndMax(int[] a) {
            if (a.length == 0) {
                return;
            }

            int min = a[0];
            int max = a[0];

            for (int i = 0; i < a.length; i++) {
                if (a[i] < min) {
                    min = a[i];
                }
                if (a[i] > max) {
                    max = a[i];
                }
            }

            System.out.println("Minimum = " + min + ", Maximum = " + max);
        }

        //ToDo:
        public static boolean isOrderedAscendingly(int[] a) {
            boolean isOrdered = true;
            for(int i = 0; i < a.length - 1; i++) {
                isOrdered &= a[i] <= a[i + 1];
            }
            return isOrdered;
        }

        public static void invert(int[] a) {
            for (int i = 0; i < a.length / 2; i++) {
                int tmp = a[i];
                int symmetricalIndex = a.length - 1 - i;
                a[i] = a[symmetricalIndex];
                a[symmetricalIndex] = tmp;
            }
        }

        public static int[] resize(int[] a, int length) {
            if (length <= 0) {
                return new int[0];
            }

            int[] resized = new int[length];

            for (int i = 0; i < length && i < a.length; i++) {
                resized[i] = a[i];
            }

            return resized;
        }

        public static int[] filterEvenNumbersFrom(int[] a) {
            int numberOfEvenElements = 0;
            for(int i = 0; i < a.length; i++) {
                if(a[i] % 2 == 0) {
                    numberOfEvenElements++;
                }
            }

            int[] out = new int[numberOfEvenElements];
            for(int i = 0, indexOut = 0; i < a.length; i++) {
                if(a[i] % 2 == 0) {
                    out[indexOut] = a[i];
                    indexOut++;
                }
            }

            return out;
        }

        public static int[] distinct(int[] a) {
            int[] outArrayWithPadding = new int[a.length];
            int firstUnusedPosition = 0;

            // Copy everything into 'outArrayWithPadding' that isn't already in there
            for(int i = 0; i < a.length; i++) {
                if(!containsBeforeIndex(outArrayWithPadding, a[i], firstUnusedPosition)) {
                    outArrayWithPadding[firstUnusedPosition] = a[i];
                    firstUnusedPosition++;
                }
            }
            return resize(outArrayWithPadding, firstUnusedPosition);
        }

        private static boolean containsBeforeIndex(int[] a, int value, int index) {
            for(int i = 0; i < index; i++) {
                if(a[i] == value) {
                    return true;
                }
            }
            return false;
        }
    }
}
