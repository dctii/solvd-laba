// src/Main.java

import java.util.Arrays;

import utils.Sort;

public class Main {
    public static void main(String[] args) {
        /* Assignment 1 start */
        String[] sortTypes = {"ascending", "descending"};

        // Loop for both sort types
        for (String sortType : sortTypes) {
            System.out.println(sortType + ":");
            // Loop quick sorting of numbers arrays
            for (Integer[] numbers : Data.allNumbersArrays) {
                Sort.quick(numbers, sortType);
                System.out.println(Arrays.toString(numbers));
            }

            // Loop quick sorting of letters arrays
            for (Character[] letters : Data.allLettersArrays) {
                Sort.quick(letters, sortType);
                System.out.println(Arrays.toString(letters));
            }
            System.out.println("\n");
        }
        /* Assignment 1 end */
    }
}
