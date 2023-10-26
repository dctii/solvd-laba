package playground;

import java.util.Arrays;
import java.text.MessageFormat;

public class Lecture1 {
    public static void main(String[] args) {
        int age = 10;
        double aDoubleNum = 5.1;
        boolean isGood = true;
        char character = 'e';
        int[] numbers = new int[3];
        numbers[0] = 5;
        numbers[1] = 3;
        numbers[2] = 55;
        int[] numbersArray = {5, 3, 10};
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(numbersArray));

        int a = 10;
        if (a > 5) {
            System.out.println("'a' is greater than or equal to 5");
        } else if (a < 20) {
            System.out.println("'a' is less than 20");
        } else {
            System.out.println("None of the initial two conditions were met.");
        }

        int b = 10;
        int x;
        if (b >= 5) {
            x = 5;
        } else {
            x = 6;
        }
        System.out.println(x);

        int z = (b >= 5) ? 30 : 45;

        System.out.println(z);

        String month = "March";
        int monthNum;

        switch (month) {
            case "January":
                monthNum = 1;
                break;
            case "February":
                monthNum = 2;
                break;
            case "March":
                monthNum = 3;
                break;
            default:
                monthNum = 0;
                break;
        }
        System.out.println(monthNum);

        // standard for-loop
        String[] names = {"John", "Sam", "Emm"};
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals("Sam")) {
                System.out.println("Sam exists 1.");
            }
        }

        // enhanced for-loop
        for (String name : names) {
            if (name.equals("Sam")) {
                System.out.println("Sam exists 2.");
            }
        }

        int i = 0;
        while (i < names.length) {
            if (names[i].equals("Sam")) {
                System.out.println("Sam exists 3.");
            }
            i++; // incrementation required or else infinite loop will occur
        }

        i = 0;
        do {
            if (names[i].equals("Sam")) {
                System.out.println("Sam exists 4.");
            }
            i++;
        } while (i < names.length);

        for (String name : names) {
            if (name.equals("Sam")) {
                System.out.println("Sam exists 5.");
                break; // use this to break from the loop
            }
        }

        for (String name : names) {
            if (!name.equals("Sam")) {
                System.out.println(MessageFormat.format("{0} is not Sam.", name));
                System.out.printf("Hello %s! You are %d years old.  %n", name, age);
                continue;
            }
        }

        String output = MessageFormat.format("Hello {0}. You are {1} years old!", names[0], age);
        System.out.println(output);


    }
}
