/**
 * Homework 1: Calculating distance and velocity
 * @Author Shao Yan
 * @Since 7/24/2022
 * @Description: This program calculates distance and velocity,
 * prompts user to enter a time (measured
 * in seconds). The program starts offs with having the user to enter a time.
 * The program then prints out the result on the screen displaying both the distance and velocity.
 * Each calculation, i.e, distance and velocity are placed in their own methods.
 * At the end of the program, the program outputs the answers to a text file.
 * I spent my class time doing this assignment, there shouldn't be any errors.
 * I was happy after working on this program.
 */

import java.io.*;
import java.util.Scanner;
import java.io.PrintStream;

public class homeWork1 {
    // these variables one line below will be used to store the calculated values.
    public static double distance, time, velocity;
    public static final double initialVelocity = 0, gravity = 9.807, half = 0.5;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        PrintStream printInfo = new PrintStream(new FileOutputStream("output.txt"));
        System.out.println("This program wil calculate velocity and time!");
        /* calling out the functions, used for-loop to test the data 10 times. */
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + ".) " + "Please enter the time (in seconds):");
            time = sc.nextDouble();
            double displayDistance = distance(time);
            double displayVelocity = velocity(time);
            printOutput(time, displayDistance, displayVelocity, printInfo);
        }
        printInfo.close();
    }

    /**
     * @param time - pass on time as parameter, returns distance
     */
    public static double distance(double time) {
        double squareTime = Math.pow(time, 2); // squares the time as shown in the formula
        distance = initialVelocity + half * (gravity) * (squareTime);
        return distance;
    }

    /**
     * @param time - Calculates velocity, passing time as parameter
     */
    public static double velocity(double time) {
        velocity = initialVelocity + gravity * time;
        return velocity;
    }

    public static void printOutput(double time, double displayDistance,
                                   double displayVelocity, PrintStream printInfo) {
        printInfo.printf("When the time is %.0f", time);
        printInfo.print(" seconds,");
        printInfo.printf(" the distance traveled is: %.2f", displayDistance);
        printInfo.print(",");
        printInfo.printf(" and the velocity is: %.2f", displayVelocity);
        printInfo.println("\n"); // Inputs a new space in line.
    }
}