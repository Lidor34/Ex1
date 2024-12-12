# Ex1

# Number Conversion Project

This program performs number conversion from different representations, performs addition and multiplication,
and converts the results to different bases (from 2 to 16).

## Description

The user enters two numbers in different representations, and the program:
1. Converts the numbers to their decimal integer values.
2. Performs addition and multiplication.
3. Converts the results back to the selected base (between 2 and 16).
4. Displays the largest number among the input numbers, addition result, and multiplication result.



#### Example:

Ex1 class solution:
Enter a string as number#1 (or "quit" to end the program): 
101b2
num1 = 101b2 is number :true value: 5
Enter a string as number#2 (or "quit" to end the program): 
A b16
num2 = Ab16 is number :true value :10
Enter a base for output : ( a number [2 - 16])
8
101b2+ Ab16 = 15b8
101b2* Ab16 = 50b8
Max number over 101b2,Ab16,101b2+A b16=15b8,101b2* Ab16=50b8 is: 50b8


### Main function's :
 ## 1 - number2Int : Convert the given number to a decimal representation .
        and if the given number is not valid the error will be -1.

 ## 2 - isNumber :This static function checks if the given String  is in a valid "number" format
       String representing a number.
       the function will return true iff the given String is in a number format.

 ## 3 - int2Number : Calculate the number representation (in basis base) of the given
        natural number (represented as an integer).

 ## 4 - equals : checks if the two numbers have the same value.
       the function will return true iff the two numbers have the same values.

 ## 5 - maxIndex : this function search for the array index with the largest number (in value).
       the function will return the index in the array in with the largest number (in value).

