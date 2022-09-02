/**
 * @Author Shao Yan
 * @Since 8/3/2022
 * @Description: This program calculates the average of students'
 * given grades. The File(Data) is provided and I do not know
 * how many sets of data that file will have, so I used a
 * trailer method(while loop) that will loop for as long as
 * there is data inside the file. Names of each student
 * were given along with their first and second test
 * grades and with their final grade.
 * @Description2: In main, the program has a while loop to read
 * in all necessary data.
 * After looping, the data will be passed onto studentAverage
 * method, where the method will calculate the average of the
 * grades passed and returns the updated value back to main.
 * Then after, the updated value will be stored in a variable
 * called showLetterGrade which then is passed down letterGrade
 * method and assigns a letter based on the grade.
 * After finishing up, the method sends the letters back to
 * main, and then I added statements to count how many got
 * the same letter grades.
 * @Description3: After tallying the letter Grades, the program
 * then takes all the data and sorts them one by one to see
 * which is the lowest and highest grade scored as well as
 * the average (total grades divided by num of students).
 * All this information is then outputted to a file, whereby
 * I called a method printGradeDistribution to print the students'
 * data with their grade.
 * Overall this assignment did require some time and patience to
 * finish, I spent a lot of time experimenting on the formatting,
 * I would say I spent more time formatting than developing the
 * code itself.
 */

import java.io.IOException;
import java.io.PrintStream;
import java.io.File;
import java.util.Scanner;

public class homeWork3 {
    static PrintStream ps;

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("StudentGrades.txt"));
        ps = new PrintStream("Roster.txt");
        printRecords(ps);
        String studentNames = "", showLetterGrade = "";
        int Test1 = 0, Test2 = 0, FinalTest = 0,
                countA = 0, countB = 0, countC = 0,
                countD = 0, countF = 0, CountData = 0;
        double Lowest = 0.0, Sum = 0.0, Highest = 0.0,
                FinalResult = 0, showComputeAvg = 0.0;
        while (input.hasNext()) {
            studentNames = input.next();
            Test1 = input.nextInt();
            Test2 = input.nextInt();
            FinalTest = input.nextInt();
            CountData++;
            showComputeAvg = computeAverage(Test1, Test2, FinalTest);
            showLetterGrade = letterGrade(showComputeAvg);
            printGradeDistribution(ps, studentNames, Test1, Test2,
                    FinalTest, showComputeAvg, showLetterGrade);

            if (showLetterGrade.equals("A")) {
                countA++;
            } else if (showLetterGrade.equals("B")) {
                countB++;
            } else if (showLetterGrade.equals("C")) {
                countC++;
            } else if (showLetterGrade.equals("D")) {
                countD++;
            } else {
                countF++;
            }
            if (showComputeAvg > 0) {
                Lowest = showComputeAvg;
            }
            if (showComputeAvg > Highest) {
                Highest = showComputeAvg;
            }
            Sum = (showComputeAvg + Sum);
            FinalResult = Sum / CountData;
        }
        printStatistics(countA, countB, countC, countD,
                countF, Lowest, Highest, FinalResult);
        ps.close();
        System.out.println("All Done!");
    }

    // I wasn't sure what printRecords do, I believe it means
    // to print the heading
    public static void printRecords(PrintStream ps) {
        ps.printf("%1s %9s %9s %9s %9s %9s%n",
                "Student", "test1", "test2",
                "Final", "Average", "Grade");
    }

    /**
     * @param test1
     * @param test2
     * @param finalTest
     * @return avg
     */
    public static double computeAverage
    (int test1, int test2, int finalTest) {
        return 0.2 * test1 + 0.3 * test2 + 0.5 * finalTest;
    }

    public static String letterGrade(double grade) {
        String letterGrade;
        if (grade >= 90) {
            letterGrade = "A";
        } else if (grade >= 80) {
            letterGrade = "B";
        } else if (grade >= 70) {
            letterGrade = "C";
        } else if (grade >= 60) {
            letterGrade = "D";
        } else {
            letterGrade = "F";
        }
        return letterGrade;
    }

    // this prints the students' grade, I believe this
    // was also what printRecords was supposed to do
    public static void printGradeDistribution
    (PrintStream ps, String studentNames,
     int test1, int test2,
     int finalGrade, double Average,
     String letterGrade) {
        ps.printf("%-10s %5d %9d %8d %10.2f %8s%n",
                studentNames, test1, test2,
                finalGrade, Average, letterGrade);
    }

    //This prints out the number of A's and
    //other letter grades tallied up in main.
    public static void printStatistics
    (int countA, int countB, int countC,
     int countD, int countF, double lowest,
     double Highest, double FinalResult) {
        ps.println("\nThe number of A grades is: " + countA);
        ps.println("The number of B grades is: " + countB);
        ps.println("The number of C grades is: " + countC);
        ps.println("The number of D grades is: " + countD);
        ps.println("The number of F grades is: " + countF);

        ps.println("\nLowest average: " + lowest);
        ps.println("Highest grade: " + " " + Highest);
        ps.println("Class Average : " + FinalResult);
        ps.println("\nAll Done!");
    }
}
