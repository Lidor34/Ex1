/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1 {
    /**
     * Convert the given number (num) to a decimal representation (as int).
     * It the given number is not in a valid format returns -1.
     *
     * @param num a String representing a number in basis [2,16]
     * @return
     */
    public static int number2Int(String num) {
        // Find the index of the 'b'
        int bIndex = num.indexOf('b');
        if (bIndex == -1 || bIndex == num.length() - 1) {
            return -1; // No base was given
        }

        // Extract the base part (everything after 'b')
        String basePart = num.substring(bIndex + 1);
        int base;

        // Extract the base if it's a letter (like 'A', 'B', etc.) or a number
        if (basePart.length() == 1 && Character.isLetter(basePart.charAt(0))) {
            base = Character.toUpperCase(basePart.charAt(0)) - 'A' + 10;
        } else {
            base = Integer.parseInt(basePart);  // Base was given as a numeric value
        }

        // Extract the number part (everything before 'b')
        String number = num.substring(0, bIndex);
        int decVal = 0; // This will store the final decimal value
        int pow = 1;  // Start with base^0, which is 1

        // Process the number from right to left (start with the least significant digit)
        for (int i = number.length() - 1; i >= 0; i--) {
            char digit = number.charAt(i);
            int value;

            // If the digit is a letter (e.g., A, B, C... for bases greater than 10)
            if (Character.isLetter(digit)) {
                value = Character.toUpperCase(digit) - 'A' + 10;
            } else {
                value = digit - '0';  // Convert a digit character to its integer value
            }

            // Add the current digit's value times its position power of the base
            decVal += value * pow;

            // Update the power of the base for the next digit (base^0, base^1, base^2, ...)
            pow *= base;
        }

        return decVal;  // Return the final decimal value
    }

    /**
     * This static function checks if the given String (g) is in a valid "number" format.
     *
     * @param a a String representing a number
     * @return true iff the given String is in a number format
     */
    public static boolean isNumber(String a) {
        // Base cases
        if (a == null || a.isEmpty()) {
            return false;
        }

        // Check if the string contains only digits
        for (int i = 0; i < a.length(); i++) {
            if (!Character.isDigit(a.charAt(i))) {
                return false;
            }
        }

        return true;  // All characters are digits, valid number format
    }

    /**
     * Calculate the number representation (in basis base)
     * of the given natural number (represented as an integer).
     * If num<0 or base is not in [2,16] the function should return "" (the empty String).
     *
     * @param num  the natural number (include 0).
     * @param base the basis [2,16]
     * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
     */
    public static String int2Number(int num, int base) {
       if(num == 0) return "0";
       num = Math.abs(num);
       StringBuilder res = new StringBuilder();
       while(num > 0) {
             int remainder = num % base;
             char digit;
             if ( remainder < 10)
                 digit = (char) ('0' + remainder);
             else
                 digit = (char) ( 'A' + ( remainder - 10));
             res.append(digit);
             num /=base;
       }
       return res.reverse().toString();
    }

    /**
     * Checks if the two numbers have the same value.
     *
     * @param n1 first number
     * @param n2 second number
     * @return true iff the two numbers have the same values.
     */
    public static boolean equals(String n1, String n2) {
        if (n1 == null || n2 == null) {
            return false;  // Return false if either number is null
        }
        int value1 = number2Int(n1);
        int value2 = number2Int(n2);
        // Check if both values are valid (not -1)
        if (value1 == -1 || value2 == -1) {
            return false;  // Return false if either number is invalid
        }
        return value1 == value2;  // Return true if values are equal
    }


    /**
     * This static function search for the array index with the largest number (in value).
     * In case there are more than one maximum - returns the first index.
     * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
     *
     * @param arr an array of numbers
     * @return the index in the array in with the largest number (in value).
     */
    public static int maxIndex(String[] arr) {
        int ansIndex = -1; // Start with -1 to handle the case when no valid numbers are found
        int maxValue = Integer.MIN_VALUE; // Initialize to the smallest integer value

        for (int i = 0; i < arr.length; i++) {
            int value;
            if (arr[i] != null) { // Ensure the element is not null
                if(i==2 || i==3) {
                     value = number2Int(arr[i]);
                     System.out.println(value);
                }else {
                     value = Integer.parseInt(arr[i]);
                }
                // Skip invalid numbers with value -1
                if (value != -1 && value > maxValue) {
                    maxValue = value;  // Update maxValue
                    ansIndex = i;      // Update the index of the max value
                }
            }
        }

        return ansIndex; // Return the index of the maximum valid value
    }

}
