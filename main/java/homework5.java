/**
 * Homework 5: Seating arrangement.
 *
 * @Author: Shao Yan
 * @Since: 8/13/2022
 * @Description: A list of information was given but the information
 * was not sorted according to seating arrangement. The task is to sort
 * and arrange the information based on the seating arrangement.
 * In addition, to the far right there are numbers, and it is used to
 * indicate the title of each individual. (Mr, Mrs, Ms, Miss).
 * @Description2: The program reads in the file (party.txt) by calling
 * a method called readData. After reading the data, it's called in
 * main method, where numberOfElements defines the size of array.
 * BubbleSort method, sorts the array and its name according to
 * seating number and then lastly, replaceTitles method
 * replaces the number with the respective titles. Finally, I've
 * written another method for printing out the names to output.
 * @Description3: This program was a little easier than the previous
 * program because there were fewer instructions to work on. I think
 * this was a fair homework that was quite easy to do, testing
 * the logic with arrays.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class homework5 {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream ps = new PrintStream("organized.txt");
        Scanner sc = new Scanner(new File("party.txt"));
        int size = 15, numberOfElements;
        String[] attendants = new String[size];
        int[] position = new int[size];
        int[] titles = new int[size];

        numberOfElements = readData(attendants, position, titles, sc);
        bubbleSort(position, attendants, titles);
        String[] text = replace(titles);
        print(attendants, position, numberOfElements, text, ps);
    }

    public static int readData(String[] attendants, int[] position,
                               int[] titles, Scanner sc) {
        int i = 0;
        while (sc.hasNext()) {
            attendants[i] = sc.next() + " " + sc.next();
            position[i] = sc.nextInt();
            titles[i] = sc.nextInt();
            i++;
        }
        return i;
    }

    // the bubble sort we learnt in class.
    public static void bubbleSort(int[] arr, String[] names,
                                  int[] titles) {
        int temp = 0;
        String name = "";
        int title = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    name = names[j];
                    title = titles[j];
                    names[j] = names[j + 1];
                    titles[j] = titles[j + 1];
                    names[j + 1] = name;
                    titles[j + 1] = title;
                }
            }
        }
    }

    // replace text with appropriate titles.
    public static String[] replace(int[] arr) {

        String[] strArray = new String[arr.length];
        int i;

        for (i = 0; i < arr.length; i++) {
            strArray[i] = String.valueOf(arr[i]);
        }
        for (i = 0; i < strArray.length; i++) {
            switch (strArray[i]) {
                case "1":
                    strArray[i] = "Mr.";
                    break;
                case "2":
                    strArray[i] = "Mrs.";
                    break;
                case "3":
                    strArray[i] = "Ms.";
                    break;
                default:
                    strArray[i] = "Miss";
                    break;
            }
        }
        return strArray;
    }

    public static void print(String[] attendants, int[] position,
                             int num, String[] arr, PrintStream ps) {
        for (int i = 0; i < num; i++) {
            ps.println(position[i] + "	" + arr[i]
                    + " " + attendants[i]);
        }
    }
}