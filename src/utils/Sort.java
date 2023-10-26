// src/utils/Sort.java
package utils;


public class Sort {

    /* *
     * @param T[] array: array of items including to-be-sorted items
     * @param int index1: item at index1 to swap with item at index2
     * @param int index2: item at index2 to swap with item at index1
     * */
    private static <T> void swap(T[] array, int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    /* *
     * @param T comparandum: subject for comparing
     * @param T comparans: criteria to compare subject against
     * @param String sortType: determines "ascending" or "descending" order of elements
     * @return -1: value signaling comparandum is lt comparans
     * @return 1: value signaling comparandum is gt comparans
     * @return 0: value signaling comparandum is eq to comparans
     * @throw IllegalArgumentException if arguments are neither Integer nor Character
     * @throw IllegalArgumentException if arguments are not the same type
     * */
    private static <T> int compare(T comparandum, T comparans, String sortType) {
        if (comparandum instanceof Integer || comparandum instanceof Character) {
            int a = 0;
            int b = 0;
            if (comparandum instanceof Integer && comparans instanceof Integer) {
                a = (Integer) comparandum;
                b = (Integer) comparans;
            } else if (comparandum instanceof Character && comparans instanceof Character) {
                a = (Character) comparandum;
                b = (Character) comparans;
            } else {
                throw new IllegalArgumentException("comparandum and comparans must be Integer or " +
                        "Character.");
            }

            switch (sortType) {
                case "asc":
                case "ascending":
                    if (a < b) {
                        return -1;
                    } else if (a > b) {
                        return 1;
                    } else {
                        return 0;
                    }
                case "desc":
                case "descending":
                    if (a < b) {
                        return 1;
                    } else if (a > b) {
                        return -1;
                    } else {
                        return 0;
                    }
                default:
                    throw new IllegalArgumentException("sortType can only be String with value " +
                            "'asc', 'ascending', 'desc', 'descending'.");
            }

        } else {
            throw new IllegalArgumentException("comparandum and comparans must have the same " +
                    "type.");
        }
    }

    /* *
     * @param T[] array: range of items to be sorted
     * @param int startIndex: the index of the left-most item in the given range
     * @param int endIndex: the index of the right-most item in the given range
     * @param boolean isFirstCall: allows randomly selected index for pivot on the first call
     * @param String sortType: determines "ascending" or "descending" order of elements
     * @return int foundPivot: the index of the pivot element to be used in the range
     * */
    private static <T> int findPivot(T[] array, int startIndex, int endIndex, boolean isFirstCall,
                                     String sortType) {


        if (isFirstCall) {
            int randomIndex = (int) (Math.random() * (endIndex - startIndex + 1)) + startIndex;
            swap(array, startIndex, randomIndex);
        }

        int pivotIndex = startIndex;

        int leftIndex = startIndex + 1;
        int rightIndex = endIndex;

        while (leftIndex <= rightIndex) {
            while (leftIndex <= rightIndex && compare(array[leftIndex], array[pivotIndex], sortType) <= 0) {
                leftIndex++;
            }

            while (leftIndex <= rightIndex && compare(array[rightIndex], array[pivotIndex], sortType) >= 0) {
                rightIndex--;
            }

            if (leftIndex <= rightIndex) {
                swap(array, leftIndex, rightIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        swap(array, pivotIndex, rightIndex);
        int foundPivot = rightIndex;
        return foundPivot;
    }

    /* *
     * @param T[] array: items array to be sorted
     * @param int leftIndex: index of left-most item of array
     * @param int rightIndex: index of right-most item of array
     * @param boolean isFirstCall: allows randomly selected index for pivot on the first call
     * @param String sortType: determines "ascending" or "descending" order of elements
     * @base-case: break out if leftIndex less-than rightIndex
     * */
    private static <T> void sortSection(T[] array, int leftIndex, int rightIndex,
                                        boolean isFirstCall,
                                        String sortType) {
        if (leftIndex < rightIndex) {
            int pivotIndex = findPivot(array, leftIndex, rightIndex, isFirstCall, sortType);
            sortSection(array, leftIndex, pivotIndex - 1, false, sortType);
            sortSection(array, pivotIndex + 1, rightIndex, false, sortType);
        } else {
            // break out of recursion;
        }
    }

    /* *
     * @param T[] array: array of items to-be-sorted
     * @param String sortType: string denoting 'ascending' or 'descending' order
     * */
    public static <T> void quick(T[] array, String sortType) {
        if (array == null || array.length <= 1) {
            return;
        }

        sortSection(array, 0, array.length - 1, true, sortType);
    }
}
