public class _DeletingArray {
    public static void main(String[] args) {
        //int[] arr = {1, 2, 9, 3, 3, 4, 5, 5, 7, 7, 6, 9, 9, 8, 8, 8, 8, 3, 3, 2, 7};
        int[] arr2 = {1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9};
        //int length = arr.length;
        int length2 = arr2.length;

        //sortedArray(arr, length);
        System.out.println("Sorted array: ");
        //for (int i = 0; i < length; i++) {
        //  System.out.print(arr[i] + " ");
        //  }

        System.out.println("\nremove duplicates: ");
        length2 = removeDuplicates(arr2, length2);
        for (int j = 0; j < length2 - 1; j++) {
            System.out.print(arr2[j] + " ");
        }
    }

    public static int sortedArray(int[] arr, int num) {
        int temp = 0;

        for (int i = 0; i < num - 1; i++) {
            for (int j = 0; j < num - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return temp;
    }

    public static int removeDuplicates(int[] arr, int num) {
        if (num == 0 || num == 1) {
            return num;
        }
        // creating temp placeholder.
        int[] temp = new int[num];
        int j = 0;

        for (int i = 0; i < num - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                temp[j++] = arr[j];
            }
        }
        temp[j++] = arr[num - 1];
        // copying the variables
        for (int i = 0; i < j; i++) {
            arr[i] = temp[i];
        }
        return j;
    }
}
