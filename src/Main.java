// src/Main.java

import java.util.Arrays;

import utils.Sort;

public class Main {
    public static void main(String[] args) {
        String[] sortTypes = {"ascending", "descending"};

        for (String sortType : sortTypes) {
            System.out.println(sortType + ":");
            for (Integer[] numbers : Data.allNumbersArrays) {
                Sort.quick(numbers, sortType);
                System.out.println(Arrays.toString(numbers));
            }

            for (Character[] letters : Data.allLettersArrays) {
                Sort.quick(letters, sortType);
                System.out.println(Arrays.toString(letters));
            }
            System.out.println("\n");
        }
    }
}
