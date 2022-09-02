/**
 * Homework 4: Weather Analysis
 *
 * @Author Shao Yan
 * @Since 8/9/2022
 * @Description: This program analyses each week's weather temperature
 * from a file and does various calculations, including finding the
 * lowest, highest, mean(avg), and consecutive (same temperature
 * occurring two or more days). The program only included
 * weekdays for a total of five weeks. Each calculation is done
 * using a method, main does the printing and calling the function.
 * Each method has its own comments that gives a description, but
 * I will also summarize it here so the program is more
 * understandable (Please read description 2 for more
 * details - It has everything).
 * @Description2: I wrote a method that reads in the data from
 * the file, using a while loop and i as the counter. After
 * reading the data, the data is sent back to main.
 * New Variable is passed on the method's
 * parameter. (HighestMean and LowestMean respectively)
 * After which, the highest of each week is stored into an
 * array called DayHighest, which then will be passed
 * to a method called findHighest and then returns the
 * highest within the 5 weeks (Stored in a variable
 * called: HighestMeanForWeek.) Now there is another method
 * that checks its location(index) and since index
 * starts at 0, I had to add one(1) since week begins at
 * week 1 (people don't say week 0) which is done in
 * method called HowManyWeeks. The instruction also said
 * to print "Yes" or "No" whether each week had two or more
 * of the same temps consecutively. (This method is called
 * checkForAdjacents. I will explain the method as you read
 * along.) The method WhichDay, simply defines the Day in which
 * the highest temperature occurred. I could have reused some
 * methods to solve similar problems, but I'd rather not
 * confuse myself too much and I really enjoy coding and typing
 * while I am solving problems. (Please read description 3 -)
 * @Description3: I started this program when I first got the
 * handout because I knew this was going to be a more
 * challenging homework, which of course, it really is.
 * I thought I was supposed to do a 2-Dimensional array since
 * the file looked like a matrix. I decided to take the
 * challenge (since I haven't really worked with 2D arrays).
 * I did spend over 2 days writing and optimizing the 2D array
 * and I got the results as expected, till today Professor
 * told me that I cannot use 2D arrays. I had limited time, and I
 * rushed through this assignment.
 * I felt I need more time to clean up here and there(you will
 * see some things that are redundant because I do not have
 * the time to clean up, and I take some time in doing your
 * assignments). I wish I can ask for more time, but I admit it is
 * my fault for not asking whether I should have looped using
 * nested forLoop and create a 2D array. I spend a lot of time
 * doing your assignments because I know I really cannot do well
 * on exams, so assignments are my only hope. I've been trying
 * to dedicate some time working on the assignments but life
 * always keeps me occupied. I've spent a lot of time on
 * formatting and indentation, so code should look at neat as possible.
 * I think assignments are a better way to engage students to learn
 * programming and to keep them busy in every way possible.
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class hit {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("Weather.txt"));
        PrintStream ps = new PrintStream("Results.txt");
        ps.printf("%7s %7s %7s %7s %7s %8s %8s %8s %15s",
                "Mon", "Tue", "Wed", "Thurs",
                "Fri", "Low", "High", "Mean", "Consecutive");
        ps.println();
        int size = 5, i = 0;

        // Hold the arrays
        int[] Monday = new int[size];
        int[] Tuesday = new int[size];
        int[] Wednesday = new int[size];
        int[] Thursday = new int[size];
        int[] Friday = new int[size];

        readData(Monday, Tuesday, Wednesday, Thursday, Friday, sc);

        // Calling the Lowest:
        int Mon = LowestMean(Monday);
        int Tues = LowestMean(Tuesday);
        int Wed = LowestMean(Monday);
        int Thurs = LowestMean(Thursday);
        int Fri = LowestMean(Friday);

        // Calling the Highest for day:
        int HighMon = HighestMean(Monday);
        int HighTue = HighestMean(Tuesday);
        int HighWed = HighestMean(Wednesday);
        int HighThu = HighestMean(Thursday);
        int HighFri = HighestMean(Friday);

        //Storing the highest and compare them
        int[] DayHighest = new int[size];
        DayHighest[0] = HighMon;
        DayHighest[1] = HighTue;
        DayHighest[2] = HighWed;
        DayHighest[3] = HighThu;
        DayHighest[4] = HighFri;

        // Calling consecutive days:
        String Mondae = checkForAdjacents(Monday);
        String Tuesdae = checkForAdjacents(Tuesday);
        String Wednesdae = checkForAdjacents(Wednesday);
        String Thursdae = checkForAdjacents(Thursday);
        String Fridae = checkForAdjacents(Friday);

        // This method finds the highest for the entire week
        int HighestPerWeek = findHighest(DayHighest);

        // This method locates the index, and determines
        // the highest temp for the week.
        int HighestMeanForWeek = findLocationByWeek(DayHighest);

        // Since index starts at 0, and week starts with 1,
        // I decided to add 1 to each index.
        int HowManyWeeks = HowManyWeeks(HighestMeanForWeek);

        // This Prints the day in which the highest temp
        // was recorded for.
        String whichDay = WhichDay(HighestMeanForWeek);

        for (i = 0; i < Monday.length; i++) {
            ps.printf("%7d ", Monday[i]);
            ps.printf("%7d ", Tuesday[i]);
            ps.printf("%7d ", Wednesday[i]);
            ps.printf("%7d ", Thursday[i]);
            ps.printf("%7d %n", Friday[i]);
        }

        ps.print("          " + Mon + "       "
                + HighMon + "          " + Mondae + "\n");

        ps.print("          " + Tues + "       "
                + HighThu + "          " + Tuesdae + "\n");
        ps.print("          " + Wed + "       "
                + HighWed + "          " + Wednesdae + "\n");
        ps.print("          " + Thurs + "       "
                + HighThu + "          " + Thursdae + "\n");
        ps.print("          " + Fri + "       "
                + HighFri + "          " + Fridae + "\n");

        ps.println("\n \n" + HowManyWeeks + " weeks were processed. ");
        ps.println("The Highest temp occurred on "
                + whichDay);
        ps.println("The Highest Temp occurred on week "
                + HighestMeanForWeek);
    }

    // Using a method to read in a list of rows
    public static int readData(int[] Monday, int[] Tuesday,
                               int[] Wednesday,
                               int[] Thursday,
                               int[] Friday, Scanner sc) {
        int i = 0;
        while (sc.hasNextLine()) {
            {
                Monday[i] = sc.nextInt();
                Tuesday[i] = sc.nextInt();
                Wednesday[i] = sc.nextInt();
                Thursday[i] = sc.nextInt();
                Friday[i] = sc.nextInt();
                i++;
            }
        }
        return i;
    }

    // finding the highest mean in each week
    public static int HighestMean(int[] array) {
        int Highest = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > Highest) {
                Highest = array[i];
            }
        }
        return Highest;
    }

    // finding the lowest mean in each week
    public static int LowestMean(int[] array) {
        int Lowest = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < Lowest) {
                Lowest = array[i];
            }
        }
        return Lowest;
    }

    // finding consecutive temps between two days
    // array.length has -1 because if there is no
    // -1 then it would create a outOfBondException.
    // array[i + 1] means loop for the element to the
    // right.
    public static String checkForAdjacents(int[] array) {
        String textHolder = "";
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i + 1]) {
                textHolder = "Yes";
            } else {
                textHolder = "No";
            }
        }
        return textHolder;
    }

    // finding the highest in all weeks
    // I made two methods to not confuse myself
    public static int findHighest(int[] array) {
        int Highest = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > Highest) {
                Highest = array[i];
            }
        }
        return Highest;
    }

    //locates the week in which the highest
    //temperature occureed
    public static int findLocationByWeek(int[] array) {
        int i, index = 0, Highest = 0;
        for (i = 0; i < array.length; i++) {
            if (array[i] > Highest) {
                Highest = array[i];
                index = i;
            }
        }
        return index;
    }

    // Adds how many weeks were processed via
    // index and array.length.
    public static int HowManyWeeks(int Highest) {
        int incrementer = 1;
        int Week = 0;
        if (Highest == 0) {
            Week = Highest + incrementer;
        } else if (Highest == 1) {
            Week = Highest + incrementer;
        } else if (Highest == 2) {
            Week = Highest + incrementer;
        } else if (Highest == 3) {
            Week = Highest + incrementer;
        } else if (Highest == 4) {
            Week = Highest + incrementer;
        }
        return Week;
    }

    // finds which day the highest temp
    // occurred.
    public static String WhichDay(int Highest) {
        String textHolder = "";
        if (Highest == 0) {
            textHolder = "Monday";
        } else if (Highest == 1) {
            textHolder = "Tuesday";
        } else if (Highest == 2) {
            textHolder = "Wednesday";
        } else if (Highest == 3) {
            textHolder = "Thursday";
        } else if (Highest == 4) {
            textHolder = "Friday";
        }
        return textHolder;
    }
}
