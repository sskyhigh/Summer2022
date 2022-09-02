/**
 * @Description: write a program that reads a three digit number,
 * prints out the number with the digits in reverse order.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.Point;

public class practice {

    public static void main(String[] args) throws FileNotFoundException {
        int size = 10;
        int[] arr = new int[size];
        readData(arr, size);
        sort(arr, size);
        System.out.println("Sorted array: ");
        for (int i = 0; i < size; i++) {
            System.out.println(arr[i]);
        }
        if (checkTwo(arr, size)) {
            System.out.println("They are the same");
        } else {
            System.out.println("They are not the same. ");
        }
    }

    public static void readData(int[] arr, int size) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("gr.txt"));
        int i = 0;
        while (sc.hasNext()) {
            arr[i] = sc.nextInt();
            i++;
        }
        System.out.println("Unsorted array: ");
        for (i = 0; i < size; i++) {
            System.out.println(arr[i]);
        }
    }

    //Bubble sort
    public static void sort(int[] arr, int size) {
        int temp;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (arr[j] >= arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    //checking for duplicates.
    public static Boolean checkTwo(int[] arr, int size) {
        Boolean check = false;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (arr[j] == arr[j + 1]) {
                    check = true;
                }
            }
        }
        return check;
    }
}


