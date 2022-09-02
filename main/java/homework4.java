
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;


public class homework4 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("Weather.txt"));
        int[][] array = read(sc);
        checkForNeighbors(array);
        calculateMean(array);
        calculateLowest(array);
        calculateHighest(array);
        HighestMean(array);
    }

    public static void textFormatting(int[][] data, boolean[] result) {
        int index = 0;
        String days = "", resultInput = "";
        for (int[] element : data) {
            if (index == 0) {
                days = "Monday";
            } else if (index == 1) {
                days = "Tuesday";
            } else if (index == 2) {
                days = "Wednesday";
            } else if (index == 3) {
                days = "Thursday";
            } else {
                days = "Friday";
            }
            System.out.format("%s: ", days);

            for (int item : element) {
                System.out.format("%d ", item);
            }
            if (result[index++]) {
                resultInput = "Yes";
                System.out.format("(%s)", resultInput);
            } else {
                resultInput = "";
            }
            System.out.println();
        }
    }

    public static void checkForNeighbors(int[][] data) {
        boolean[] adjacencyResults = new boolean[data.length];

        int adjacencyResultsIndex = 0;

        for (int[] element : data) {
            adjacencyResults[adjacencyResultsIndex++] = findAdjacency(element);
        }

        System.out.println("Weather Report: ");
        textFormatting(data, adjacencyResults);
        System.out.println();
    }

    public static boolean findAdjacency(int[] element) {
        boolean result = false;
        /*
         * nextItemIndex stores the index for the next item
         * that would be verified against the current item of the iteration.
         */
        int nexItemIndex = 0;
        /*
         * elementLimit stores the limit for keeping the nextItemIndex count
         * controlled and avoid OutOfBoundExceptions.
         */
        int elementLimit = element.length - 1;

        for (int item : element) {
            /*
             * nextItemIndex is set based on a condition that verifies
             * if nextItemIndex is under the limit to continue counting up.
             * A false case would reset the nextItemIndex to 0 meaning that
             * the end of the row has been reached.
             */
            nexItemIndex = nexItemIndex < elementLimit ? ++nexItemIndex : 0;
            if (nexItemIndex != 0) {
                int nextItem = element[nexItemIndex];
                if (item == nextItem) {
                    result = true;
                }
            }
        }

        return result;
    }

    public static int[][] read(Scanner sc) throws FileNotFoundException {
        int rows = 5;
        int columns = 5;
        int i, j;
        int[][] Temperature = new int[rows][columns];

        while (sc.hasNextLine()) {
            for (j = 0; j < Temperature.length; j++) {
                String[] line = sc.nextLine().trim().split("  ");
                for (i = 0; i < Temperature.length; i++) {
                    Temperature[i][j] = Integer.parseInt(line[i]);
                }
            }
        }
        return Temperature;
    }

    public static void calculateMean(int[][] array) {
        int row = 0;
        for (int[] element : array) {
            int keepTrack = 0;
            double mean = 0;
            for (int i = 0; i < element.length; i++) {
                keepTrack = element[i] + keepTrack;
                mean = keepTrack / array.length;
            }
            row++;
            if (row == 1) {
                System.out.printf("Monday Average: %.1f%n", mean);
            } else if (row == 2) {
                System.out.printf("Tuesday Average: %.1f%n", mean);
            } else if (row == 3) {
                System.out.printf("Wednesday Average: %.1f%n", mean);
            } else if (row == 4) {
                System.out.printf("Thursday Average: %.1f%n", mean);
            } else {
                System.out.printf("Friday Average: %.1f%n%n", mean);
            }
        }
    }

    public static void calculateHighest(int[][] array) {
        System.out.println();
        System.out.println("Highest: ");
        int row = 0;
        for (int[] element : array) {
            int keepTrack = 0;
            for (int i = 0; i < element.length; i++) {
                if (element[i] > keepTrack) {
                    keepTrack = element[i];
                }
            }
            row++;
            if (row == 1) {
                System.out.println("Monday: " + keepTrack);
            } else if (row == 2) {
                System.out.println("Tuesday: " + keepTrack);
            } else if (row == 3) {
                System.out.println("Wednesday: " + keepTrack);
            } else if (row == 4) {
                System.out.println("Thursday: " + keepTrack);
            } else {
                System.out.println("Friday: " + keepTrack);
            }
        }
    }

    public static void calculateLowest(int[][] array) {
        System.out.println();
        System.out.println("Lowest: ");
        int row = 0;
        for (int loop[] : array) {
            //int index = 0;
            int keepTrack = 999;
            for (int i = 0; i < loop.length; i++) {
                if (loop[i] < keepTrack) {
                    keepTrack = loop[i];
                }
            }
            row++;
            if (row == 1) {
                System.out.println("Monday: " + keepTrack);
            } else if (row == 2) {
                System.out.println("Tuesday: " + keepTrack);
            } else if (row == 3) {
                System.out.println("Wednesday: " + keepTrack);
            } else if (row == 4) {
                System.out.println("Thursday: " + keepTrack);
            } else {
                System.out.println("Friday: " + keepTrack);
            }
        }
    }

    public static void HighestMean(int[][] array) {
        System.out.println();
        String Text = "";
        int row = 0, max = 0, i = 0, j = 0, index = 0;
        for (int[] elements : array) {
            for (i = 0; i < array.length; i++) {
                int store = 0;
                for (j = 0; j < array.length; j++) {
                    if (elements[i] > max) {
                        max = elements[j];
                        index = j;
                    }
                }
            }
        }
        if (index == 0) {
            Text = "Monday";
            System.out.println("The Highest temperature is on "
                    + Text + " at " + max + " degrees");
        } else if (index == 1) {
            Text = "Tuesday";
            System.out.println("The Highest temperature is on "
                    + Text + " at " + max + " degrees");
        } else if (index == 2) {
            Text = "Wednesday";
            System.out.println("The Highest temperature is on "
                    + Text + " at " + max + " degrees");
        } else if (index == 3) {
            Text = "Thursday";
            System.out.println("The Highest temperature is on "
                    + Text + " at " + max + " degrees");
        } else if (index == 4) {
            Text = "Friday";
            System.out.println("The Highest temperature is on "
                    + Text + " at " + max + " degrees");
        }
    }
}

