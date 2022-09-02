/**
 * Homework 2 = Calculating BMI for an individual
 *
 * @Author Shao Yan
 * @Since 07/26/2022
 * @Description: Body Mass index(BMI) is a measure of body fat based on
 * height and weight that applies to both men and women. This program
 * should not be used for younger kids because BMI does not take into
 * account whether the weight is carried as fat or muscle, data might
 * vary based on person. This program returns the BMI of an individual
 * given the height (measured in feet and inches) and the weight.
 * This program targets people that are 18 years or older and this
 * number should only give an idea whether the person is in shape
 * (neither fat nor underweight), underweight, overweight, and
 * obese. I will list the numbers that correspond to the units
 * as you read along.
 * 0his program is free of charge and you can check your BMI
 * 24/7 with no extra cost.
 * @Description2: The program has four methods, I will provide javadocs
 * to further explain as to keep this short. In summary, each method
 * calculates and passes the new value (as parameter)
 * onto another method.
 * @Description3: Below 18.5 means underweight, between 18.5 and 24.9
 * means normal, ranging from 25 to 29.9 means overweight and anything
 * above that means obese. Finally, the PrintStatus method outputs the
 * results to a file, using the PrintStream class. I used a trailer
 * method as discussed in class (implementing the while loop) to have
 * user enter as many data as long as the inputted data is not -1.
 * Program also outputs to the console, as instructed. This program
 * was fun to code, as it let me experiment different ways in
 * solving the problem, because there is no "one way" to solve a
 * computing problem. In addition, I learnt that "printf" makes
 * the output a little neater.
 */

import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class homework2 {
    public static void main(String[] args) throws IOException {
        PrintStream PrintResult = new PrintStream("resultsV1.txt");
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to BMI calculator!");
        int Inches, Feet, Weight, Counter = 1;
        /*stores the calculated variables, passed on
        to other parameters*/
        double NewInches, FinalBMI;
        String DisplayStatus;
        System.out.println("1.) Enter the patient's height " +
                "(In feet and inches)" +
                " type -1 twice to stop. ");
        Feet = sc.nextInt();
        Inches = sc.nextInt();
        while (Feet != -1 || Inches != -1) {
            Counter++; // keeps track of how many data entered
            System.out.println("Please enter the Patient's weight");
            Weight = sc.nextInt();
            /*the if statement checks whether if
             user enters a negative number, if
             input is negative, tells user
             to enter again.*/
            if (Weight < 0) {
                System.out.println("Weight cannot be negative! " +
                        "Please try again");
                System.out.println("Please enter new weight!");
                Weight = sc.nextInt();
            }
            NewInches = ConvertToInches(Feet, Inches);
            FinalBMI = BmiCalculator(NewInches, Weight);
            DisplayStatus = WeightStatus(FinalBMI);
            PrintResults(FinalBMI, DisplayStatus, PrintResult);
            System.out.printf("Your BMI is: " + "%.1f", FinalBMI);
            System.out.print(" indicating your weight is in the " +
                    DisplayStatus + " " +
                    "\ncategory for adults for your height.\n");
            System.out.println("\n" + Counter +
                    ".) Enter the patient's height " +
                    "(In feet and inches)" +
                    " Type -1 twice to stop. ");
            Feet = sc.nextInt();
            Inches = sc.nextInt();
        }
        PrintResult.close();
    }

    /**
     * @param feet, inch, gets user's feet and inches
     * @return updated calculated feet
     */
    public static double ConvertToInches(double feet, double inch) {
        return (feet * 12) + inch;
    }

    /**
     * @param height, weight
     * @return calculated BMI
     */
    public static double BmiCalculator(double height, double weight) {
        double squareHeight = Math.pow(height, 2);
        return (weight / squareHeight) * 703;
    }

    /**
     * @param BMI - passed updated BMI.
     * @return a text that indicates the person's status
     * based on the calculated BMI.
     */
    public static String WeightStatus(double BMI) {
        String text;
        if (BMI < 18.5) {
            text = "underweight";
        } else if (BMI > 18.5 && BMI < 24.9) {
            text = "normal";
        } else if (BMI > 25 && BMI < 29.9) {
            text = "overweight";
        } else {
            text = "obese";
        }
        return text;
    }

    // outputs the results to file.
    public static void PrintResults(double BMI, String displayStatus,
                                    PrintStream PrintResult) {
        PrintResult.printf("Your BMI is: " + "%.1f", BMI);
        PrintResult.print(" indicating your weight is in the " +
                displayStatus + " \ncategory for adults for your height.");
        PrintResult.println("\n");
    }
}
