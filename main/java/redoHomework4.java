import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class redoHomework4 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("test.txt"));
        int size = 5;
        int[] Monday = new int[size];
        int[] Tuesday = new int[size];
        int[] Wednesday = new int[size];
        int[] Thursday = new int[size];
        int[] Friday = new int[size];
        int i =0;
        while(sc.hasNext() ) {
            {
                Monday[i] = sc.nextInt();
                Tuesday[i] = sc.nextInt();
                Wednesday[i] = sc.nextInt();
                Thursday[i] = sc.nextInt();
                Friday[i] = sc.nextInt();
                i++;
            }
        }
        for (i = 0; i < Monday.length; i++) {
            System.out.print(Monday[i] + " ");
            System.out.print(Tuesday[i]+ " ");
        }
        //readData(sc, Monday, Tuesday, Wednesday, Thursday, Friday);
        //System.out.print("Monday: ");

        //System.out.print(" " + "Highest: " + HighestMean(Monday));
        //System.out.print(" " + "Low: " + LowestMean(Monday));
       // System.out.print(" " + " Mean: " + meanOfTheMeans(Monday));
        //System.out.print(" " + checkForAdjacents(Monday));
        //System.out.print("\nTuesday: ");

        //System.out.print(" " + HighestMean(Tuesday) + "\n");
        //int[] DailyHighest = new int[size];
        // I stored the highest values per day to find the largest.
        //DailyHighest[0] = HighestMean(Monday);
        //DailyHighest[1] = HighestMean(Tuesday);
        //DailyHighest[2] = HighestMean(Wednesday);
        //DailyHighest[3] = HighestMean(Thursday);
        //DailyHighest[4] = HighestMean(Friday);
        //System.out.println("Highest is: " + findHighest(DailyHighest));
        //int findHighestByWeek = findLocationByWeek(DailyHighest);
        //System.out.println(findHighestByWeek);
        //System.out.println("Highest week: " + WhichWeek(findHighestByWeek));
        //System.out.println("Day: " + WhichDay(findHighestByWeek));
        sc.close();
    }
    /*
    public static int readData(Scanner sc, int[] Monday, int[] Tuesday, int[] Wednesday,
                               int[] Thursday, int[] Friday) {
        int i = 0;
        while (sc.hasNext()) {
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
     */


    public static int HighestMean(int[] array) {
        int Highest = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > Highest) {
                Highest = array[i];
            }
        }
        return Highest;
    }

    public static int LowestMean(int[] array) {
        int Lowest = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < Lowest) {
                Lowest = array[i];
            }
        }
        return Lowest;
    }

    public static double meanOfTheMeans(int[] array) {
        double element = 0, avg = 0;
        for (int i = 0; i < array.length; i++) {
            element = array[i] + element;
            avg = element / array.length;
        }
        return avg;
    }

    public static String checkForAdjacents(int[] array) {
        String textHolder = "";
        // boolean check = false;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i + 1]) {
                textHolder = "Yes";
            } else {
                textHolder = "No";
            }
        }
        return textHolder;
    }

    public static int findHighest(int[] array) {
        int Highest = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > Highest) {
                Highest = array[i];
            }
        }
        return Highest;
    }

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

    public static int WhichWeek(int Highest) {
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

