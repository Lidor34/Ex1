import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 */
public class Ex1Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\\n");
        String num1 = "", num2 = "", quit = "quit";
        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();
            if (!num1.equals("quit")) {

                System.out.println( "num1 = " + num1 + " is number :"+ Ex1.isNumber(num1)+ " value: " + num1);
                System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
                num2 = sc.next();

                if(!num2.equals("quit")){

                    System.out.println("num2 = " + num2 + " is number :"+ Ex1.isNumber(num2)+ " value :" + num2);
                    System.out.println("Enter a base for output : ( a number [2 - 16])");

                    int base = sc.nextInt();
                    int num1D = Integer.parseInt(num1);
                    int num2D = Integer.parseInt(num2);
                    String Addition = Ex1.int2Number(num1D+num2D,base)+"b"+base;
                    String Multi = Ex1.int2Number(num1D*num2D,base)+"b"+base;

                    System.out.println(num1 + " + " +num2 + " = " + Addition);
                    System.out.println(num1 + " * " +num2 + " = " + Multi);
                    String [] arr= {num1, num2, Addition, Multi};
                    int max = Ex1.maxIndex(arr);

                    System.out.println("Max number over " + String.join(",", arr) + " is: "+ arr[max]);
                }
                /////////////////////
            }
        }
        System.out.println("quiting now...");
    }
}
