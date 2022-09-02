/**
 * @author Shao Yan
 * @version 1.0
 * @since 7-18-2022
 * Description:
 * This is my first program that prompts the user to enter his/her first and last names.
 * The user can enter his/her first name, followed by enter and then last name.
 * The user can also enter his/her first name, followed by a space and last name.
 * I assumed that the user does not have a middle name, thus I left that out.
 * The program begins by displaying the message
 * to have the user enter his/her first and last name(s).
 * After hitting enter, the program displays the name of the name that was entered.
 * I am overall satisfied with this program.
 */

import java.util.Scanner;

public class homework0 {
    public static void main(String[] args) {
        String first, last; // variables that store the data that the user enters.
        Scanner sc = new Scanner(System.in); // reads in information from a keyboard.

        System.out.println("Please enter your First and Last name");
        System.out.println("Do Not Forget to press the Enter Key!");

        first = sc.next();
        last = sc.next();

        System.out.println("This is my first program!");
        System.out.println("My name is: " + first + " " + last);
    }
}
